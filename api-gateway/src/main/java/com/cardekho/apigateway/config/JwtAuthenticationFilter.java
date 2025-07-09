package com.cardekho.apigateway.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

    @Value("${jwt.secret}")
    private String secret;

    public JwtAuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            
            // Skip authentication for auth endpoints
            if (request.getPath().toString().startsWith("/api/auth")) {
                return chain.filter(exchange);
            }

            if (!request.getHeaders().containsKey("Authorization")) {
                return (Mono<Void>) this.onError(exchange, "No authorization header", HttpStatus.UNAUTHORIZED);
            }

            String token = request.getHeaders().getOrEmpty("Authorization").get(0);
            if (token == null || !token.startsWith("Bearer ")) {
                return (Mono<Void>) this.onError(exchange, "Invalid authorization header", HttpStatus.UNAUTHORIZED);
            }

            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(secret.getBytes())
                        .build()
                        .parseClaimsJws(token.substring(7))
                        .getBody();
                
                // Add user info to headers
                ServerHttpRequest modifiedRequest = exchange.getRequest().mutate()
                        .header("X-User-Id", claims.getSubject())
                        .build();
                
                return chain.filter(exchange.mutate().request(modifiedRequest).build());
            } catch (Exception e) {
                return (Mono<Void>) this.onError(exchange, "Invalid JWT token", HttpStatus.UNAUTHORIZED);
            }
        };
    }

    private org.springframework.web.server.ServerWebExchange onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        exchange.getResponse().setStatusCode(httpStatus);
        return exchange;
    }

    public static class Config {
        // Put configuration properties here
    }
}

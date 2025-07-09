package com.cardekho.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import com.cardekho.apigateway.config.JwtAuthenticationFilter;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder, GatewayFilter jwtFilter) {
        return builder.routes()
                .route("user-service", r -> r.path("/api/users/**", "/api/auth/**")
                        .filters(f -> f.filter(jwtFilter))
                        .uri("http://localhost:8082"))
                .route("car-catalog-service", r -> r.path("/api/cars/**")
                        .filters(f -> f.filter(jwtFilter))
                        .uri("http://localhost:8081"))
                .route("booking-service", r -> r.path("/api/bookings/**")
                        .filters(f -> f.filter(jwtFilter))
                        .uri("http://localhost:8083"))
                .route("frontend", r -> r.path("/**")
                        .uri("http://localhost:8084"))
                .build();
    }
}

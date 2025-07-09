# CarDekho Clone - Microservices Architecture

## Project Overview
This project is a clone of Cardekho.com built using:
- Java/Spring Boot microservices
- Event-driven architecture with Apache Kafka
- CQRS pattern with separate read/write models
- JWT authentication

## Services
1. **Car Catalog Service** (Write Model)
   - Handles CRUD for cars, brands, manufacturers
   - PostgreSQL database
   - Publishes events to Kafka

2. **Car Search Service** (Read Model)
   - Consumes Kafka events
   - Optimized Elasticsearch index for searching

3. **User Service**
   - Manages user profiles and authentication
   - MongoDB database
   - JWT token generation/validation

4. **Booking Service**
   - Handles car reservations
   - Manages delivery/pickup options
   - PostgreSQL database

5. **Review Service**
   - Manages user reviews/ratings
   - MongoDB database

6. **API Gateway**
   - Routes requests to appropriate services
   - Handles JWT validation

7. **Frontend**
   - Basic HTML templates with Thymeleaf
   - Search and listing functionality

## Setup Instructions

### Prerequisites
- Java 17+
- Docker (for databases and Kafka)
- PostgreSQL
- MongoDB
- Elasticsearch
- Kafka

### Running the System
1. Start infrastructure services:
```bash
docker-compose up -d
```

2. Build and run each service:
```bash
cd car-catalog-service && ./gradlew bootRun
cd car-search-service && ./gradlew bootRun
# Repeat for other services
```

3. Access the application at http://localhost:8080

## API Documentation
Each service provides Swagger UI at:
- http://localhost:8081/swagger-ui.html (Car Catalog)
- http://localhost:8082/swagger-ui.html (User Service)
- etc.

## Testing
Run tests for each service:
```bash
cd car-catalog-service && ./gradlew test
# Repeat for other services
```

## Deployment
For production deployment, consider:
- Kubernetes for container orchestration
- CI/CD pipeline for automated testing and deployment
- Monitoring with Prometheus/Grafana

## Future Enhancements
- Add payment service integration
- Implement recommendation engine
- Add admin dashboard
- Enhance search capabilities

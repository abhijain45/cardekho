#!/bin/bash

# Initialize databases
echo "Initializing databases..."
docker exec -i postgres psql -U postgres < init-db.sql
docker exec -i postgres psql -U postgres < sample-data.sql

# Test API endpoints
echo "\nTesting car catalog service..."
curl -s http://localhost:8081/api/cars | jq

echo "\nTesting user service..."
curl -s http://localhost:8082/api/users/test | jq

echo "\nTesting search service..."
curl -s "http://localhost:8086/api/search/cars?query=Cam" | jq

echo "\nTesting booking service..."
curl -s http://localhost:8083/api/bookings | jq

echo "\nTesting review service..."
curl -s http://localhost:8085/api/reviews | jq

echo "\nTesting frontend..."
curl -s http://localhost:8084 | grep "title"

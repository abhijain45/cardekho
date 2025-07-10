#!/bin/bash

# Load PostgreSQL sample data
echo "Loading PostgreSQL sample data..."
sudo -u postgres psql < sample-data.sql

# Load MongoDB sample data
echo "\nLoading MongoDB sample data..."
mongosh --username admin --password admin123 --authenticationDatabase admin sample-mongo-data.js

echo "\nSample data loaded successfully!"

exit 0

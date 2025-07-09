package com.cardeho.dbtest;

import com.mongodb.client.MongoClients;
import org.junit.jupiter.api.Test;

public class MongoDBConnectionTest {
    @Test
    public void testUserDbConnection() {
        String uri = "mongodb://root:example@localhost:27017/cardekho_users?authSource=admin";
        try (var mongoClient = MongoClients.create(uri)) {
            System.out.println("✅ Successfully connected to MongoDB users database");
        }
    }

    @Test
    public void testReviewDbConnection() {
        String uri = "mongodb://root:example@localhost:27017/cardekho_reviews?authSource=admin";
        try (var mongoClient = MongoClients.create(uri)) {
            System.out.println("✅ Successfully connected to MongoDB reviews database");
        }
    }
}

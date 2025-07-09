package com.cardeho.dbtest;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresqlConnectionTest {
    @Test
    public void testCatalogDbConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/cardekho_catalog";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "")) {
            System.out.println("✅ Successfully connected to PostgreSQL catalog database");
        }
    }

    @Test
    public void testBookingDbConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/cardekho_bookings";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "")) {
            System.out.println("✅ Successfully connected to PostgreSQL bookings database");
        }
    }
}

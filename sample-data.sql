-- Enhanced sample data for car catalog
\c cardekho_catalog

-- Clear existing data
TRUNCATE car, brand, manufacturer CASCADE;

-- Insert brands
INSERT INTO brand (name, country, founding_year) VALUES
('Toyota', 'Japan', 1937),
('Honda', 'Japan', 1948),
('Ford', 'USA', 1903),
('BMW', 'Germany', 1916),
('Tesla', 'USA', 2003);

-- Insert manufacturers
INSERT INTO manufacturer (name, headquarters, number_of_factories) VALUES
('Toyota Motor Corporation', 'Toyota City, Japan', 59),
('Honda Motor Co., Ltd.', 'Minato, Tokyo, Japan', 35),
('Ford Motor Company', 'Dearborn, Michigan, USA', 42),
('BMW Group', 'Munich, Germany', 31),
('Tesla, Inc.', 'Austin, Texas, USA', 6);

-- Insert cars
INSERT INTO car (model, year, color, price, fuel_type, transmission, brand_id, manufacturer_id) VALUES
('Camry', 2023, 'Silver', 25000.00, 'Petrol', 'Automatic', 1, 1),
('Civic', 2023, 'Red', 22000.00, 'Petrol', 'Automatic', 2, 2),
('F-150', 2023, 'Black', 35000.00, 'Diesel', 'Automatic', 3, 3),
('X5', 2023, 'White', 60000.00, 'Petrol', 'Automatic', 4, 4),
('Model 3', 2023, 'Blue', 45000.00, 'Electric', 'Automatic', 5, 5);

-- Sample data for bookings
\c cardekho_bookings

-- Clear existing data
TRUNCATE booking;

INSERT INTO booking (user_id, car_id, booking_date, delivery_date, status, payment_id, total_amount) VALUES
(1, 1, NOW(), NOW() + INTERVAL '7 days', 'CONFIRMED', 'pay_12345', 25000.00),
(2, 3, NOW(), NOW() + INTERVAL '5 days', 'PENDING', NULL, 35000.00);

-- Initialize car catalog database
\c cardekho_catalog

CREATE TABLE IF NOT EXISTS brand (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    country VARCHAR(100),
    founding_year INTEGER
);

CREATE TABLE IF NOT EXISTS manufacturer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    headquarters VARCHAR(100),
    number_of_factories INTEGER
);

CREATE TABLE IF NOT EXISTS car (
    id SERIAL PRIMARY KEY,
    model VARCHAR(100) NOT NULL,
    year INTEGER,
    color VARCHAR(50),
    price DECIMAL(10,2),
    fuel_type VARCHAR(50),
    transmission VARCHAR(50),
    brand_id INTEGER REFERENCES brand(id),
    manufacturer_id INTEGER REFERENCES manufacturer(id)
);

-- Initialize booking database
\c cardekho_bookings

CREATE TABLE IF NOT EXISTS booking (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    car_id BIGINT NOT NULL,
    booking_date TIMESTAMP NOT NULL,
    delivery_date TIMESTAMP,
    delivery_address TEXT,
    status VARCHAR(20) NOT NULL,
    payment_id VARCHAR(100),
    total_amount DECIMAL(10,2),
    color VARCHAR(50),
    engine_type VARCHAR(50)
);

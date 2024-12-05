-- V1__Create_Schema.sql

CREATE TABLE Users (
    user_id BIGINT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    sports BOOLEAN,
    theatre BOOLEAN,
    concerts BOOLEAN,
    jazz BOOLEAN,
    classical BOOLEAN,
    opera BOOLEAN,
    rock BOOLEAN,
    vegas BOOLEAN,
    broadway BOOLEAN,
    musicals BOOLEAN
);

CREATE TABLE Venues (
    venue_id BIGINT PRIMARY KEY,
    venue_name VARCHAR(255) NOT NULL,
    city VARCHAR(255),
    state VARCHAR(255),
    seating_capacity INT
);

CREATE TABLE Categories (
    category_id BIGINT PRIMARY KEY,
    category_group VARCHAR(255),
    category_name VARCHAR(255) NOT NULL,
    category_description TEXT
);

CREATE TABLE Dates (
    date_id BIGINT PRIMARY KEY,
    calendar_date DATE,
    `day` VARCHAR(2),
    `week` INT,
    `month` VARCHAR(3),
    `quarter` INT,
    `year` INT,
    holiday_flag BOOLEAN
);

CREATE TABLE Events (
    event_id BIGINT PRIMARY KEY,
    venue_id BIGINT,
    category_id BIGINT,
    date_id BIGINT,
    event_name VARCHAR(255) NOT NULL,
    event_start_time TIMESTAMP,
    FOREIGN KEY (venue_id) REFERENCES Venues(venue_id),
    FOREIGN KEY (category_id) REFERENCES Categories(category_id),
    FOREIGN KEY (date_id) REFERENCES Dates(date_id)
);

CREATE TABLE Listings (
    listing_id BIGINT PRIMARY KEY,
    seller_id BIGINT,
    event_id BIGINT,
    date_id BIGINT,
    number_of_tickets INT,
    price_per_ticket DECIMAL(10, 2),
    total_price DECIMAL(10, 2),
    listing_timestamp TIMESTAMP,
    FOREIGN KEY (seller_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id),
    FOREIGN KEY (date_id) REFERENCES Dates(date_id)
);

CREATE TABLE Sales (
    sale_id BIGINT PRIMARY KEY,
    listing_id BIGINT,
    seller_id BIGINT,
    buyer_id BIGINT,
    event_id BIGINT,
    date_id BIGINT,
    quantity_sold INT,
    price_paid DECIMAL(10, 2),
    commission_amount DECIMAL(10, 2),
    sale_timestamp TIMESTAMP,
    FOREIGN KEY (listing_id) REFERENCES Listings(listing_id),
    FOREIGN KEY (seller_id) REFERENCES Users(user_id),
    FOREIGN KEY (buyer_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id),
    FOREIGN KEY (date_id) REFERENCES Dates(date_id)
);
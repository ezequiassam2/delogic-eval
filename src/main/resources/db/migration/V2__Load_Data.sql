-- V2__Load_Data.sql

LOAD DATA INFILE 'data/users.txt'
INTO TABLE Users
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n'
(user_id, username, first_name, last_name, city, state, email, phone, sports, theatre, concerts, jazz, classical, opera, rock, vegas, broadway, musicals);

LOAD DATA INFILE 'data/venues.txt'
INTO TABLE Venues
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n'
(venue_id, venue_name, city, state, seating_capacity);

LOAD DATA INFILE 'data/categories.txt'
INTO TABLE Categories
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n'
(category_id, category_group, category_name, category_description);

LOAD DATA INFILE 'data/dates_2008.txt'
INTO TABLE Dates
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n'
(date_id, calendar_date, day, week, month, quarter, year, holiday_flag);

LOAD DATA INFILE 'data/events.txt'
INTO TABLE Events
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n'
(event_id, venue_id, category_id, date_id, event_name, event_start_time);

LOAD DATA INFILE 'data/listings.txt'
INTO TABLE Listings
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n'
(listing_id, seller_id, event_id, date_id, number_of_tickets, price_per_ticket, total_price, listing_timestamp);

LOAD DATA INFILE 'data/sales.txt'
INTO TABLE Sales
FIELDS TERMINATED BY '\t'
LINES TERMINATED BY '\n'
(sale_id, listing_id, seller_id, buyer_id, event_id, date_id, quantity_sold, price_paid, commission_amount, sale_timestamp);
-- V2__Load_Data.sql

LOAD DATA INFILE '/var/lib/mysql-files/users.txt'
INTO TABLE users
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n'
(user_id, username, first_name, last_name, city, state, email, phone, @sports, @theatre, @concerts, @jazz, @classical, @opera, @rock, @vegas, @broadway, @musicals)
SET
    sports = CASE WHEN @sports = 'TRUE' THEN 1 ELSE 0 END,
    theatre = CASE WHEN @theatre = 'TRUE' THEN 1 ELSE 0 END,
    concerts = CASE WHEN @concerts = 'TRUE' THEN 1 ELSE 0 END,
    jazz = CASE WHEN @jazz = 'TRUE' THEN 1 ELSE 0 END,
    classical = CASE WHEN @classical = 'TRUE' THEN 1 ELSE 0 END,
    opera = CASE WHEN @opera = 'TRUE' THEN 1 ELSE 0 END,
    rock = CASE WHEN @rock = 'TRUE' THEN 1 ELSE 0 END,
    vegas = CASE WHEN @vegas = 'TRUE' THEN 1 ELSE 0 END,
    broadway = CASE WHEN @broadway = 'TRUE' THEN 1 ELSE 0 END,
    musicals = CASE WHEN @musicals = 'TRUE' THEN 1 ELSE 0 END;

LOAD DATA INFILE '/var/lib/mysql-files/venues.txt'
INTO TABLE venues
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n'
(venue_id, venue_name, city, state, seating_capacity);

LOAD DATA INFILE '/var/lib/mysql-files/categories.txt'
INTO TABLE categories
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n'
(category_id, category_group, category_name, category_description);

LOAD DATA INFILE '/var/lib/mysql-files/dates_2008.txt'
INTO TABLE dates
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n'
(date_id, calendar_date, day, week, month, quarter, year, @holiday_flag)
SET
    holiday_flag = CASE WHEN @holiday_flag = 'TRUE' THEN 1 ELSE 0 END;

LOAD DATA INFILE '/var/lib/mysql-files/events.txt'
INTO TABLE events
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n'
(event_id, venue_id, category_id, date_id, event_name, event_start_time);

LOAD DATA INFILE '/var/lib/mysql-files/listings.txt'
INTO TABLE listings
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n'
(listing_id, seller_id, event_id, date_id, number_of_tickets, price_per_ticket, total_price, listing_timestamp);

LOAD DATA INFILE '/var/lib/mysql-files/sales.txt'
INTO TABLE sales
FIELDS TERMINATED BY '\t'
LINES TERMINATED BY '\n'
(sale_id, listing_id, seller_id, buyer_id, event_id, date_id, quantity_sold, price_paid, commission_amount, sale_timestamp);
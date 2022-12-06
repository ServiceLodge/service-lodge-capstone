CREATE DATABASE IF NOT EXISTS lodging_db;

USE lodging;

CREATE TABLE IF NOT EXISTS persons(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(200) NOT NULL,
    last_name VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    phone_number INT(10) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS wings(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    wing_name VARCHAR(200) NOT NULL UNIQUE,
    state VARCHAR(2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS admins(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    person_id INT UNSIGNED NOT NULL,
    wing_id INT UNSIGNED NOT NULL,
    password VARCHAR(200),
    PRIMARY KEY (id),
    FOREIGN KEY (person_id) REFERENCES persons (id),
    FOREIGN KEY (wing_id) REFERENCES wings(id)
);

CREATE TABLE IF NOT EXISTS units(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    wing_id INT UNSIGNED NOT NULL,
    unit_name VARCHAR(200) NOT NULL UNIQUE,
    PRIMARY KEY (id),
    FOREIGN KEY (wing_id) REFERENCES wings(id)
);

CREATE TABLE IF NOT EXISTS members(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    person_id INT UNSIGNED NOT NULL,
    unit_id INT UNSIGNED NOT NULL,
    password VARCHAR(200),
    PRIMARY KEY (id),
    FOREIGN KEY (person_id) REFERENCES persons(id),
    FOREIGN KEY (unit_id) REFERENCES wings(id)
);

CREATE TABLE IF NOT EXISTS drills(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    wing_id INT UNSIGNED NOT NULL,
    name VARCHAR(20) NOT NULL UNIQUE,
    drill_start_date DATE NOT NULL,
    drill_end_date DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (wing_id) REFERENCES wings(id)
);

CREATE TABLE IF NOT EXISTS hotels(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL UNIQUE,
    address VARCHAR(200) NOT NULL UNIQUE,
    city VARCHAR(200) NOT NULL UNIQUE,
    state VARCHAR(2) NOT NULL,
    zip INT(7) NOT NULL,
    phone_number INT(10) NOT NULL UNIQUE,
    email VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS reservations(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    member_id INT UNSIGNED NOT NULL,
    drill_id INT UNSIGNED NOT NULL,
    hotel_id INT UNSIGNED NOT NULL,
    res_num VARCHAR(200) NOT NULL,
    res_start_date DATE,
    res_end_date Date,
    PRIMARY KEY (id),
    FOREIGN KEY (member_id) REFERENCES members(id),
    FOREIGN KEY (drill_id) REFERENCES drills(id),
    FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);


INSERT INTO persons (first_name, last_name, email, phone_number)
VALUES (
           'John', 'Doe', 'john.doe@codeup.com', 1234567890
       );
INSERT INTO persons (first_name, last_name, email, phone_number)
VALUES (
           'Bob', 'White', 'bob.white@codeup.com', 1234567891
       );
INSERT INTO persons (first_name, last_name, email, phone_number)
VALUES (
           'Bob', 'Blue', 'bob.blue@codeup.com', 1234567892
       );
INSERT INTO persons (first_name, last_name, email, phone_number)
VALUES (
           'Bob', 'Green', 'bob.green@codeup.com', 1234567893
       );

INSERT INTO wings (wing_name, state) VALUES ('184th Wing', 'TX');

INSERT INTO admins (person_id, wing_id, password)
VALUES (1,1,'password');

INSERT INTO units (wing_id, unit_name)
VALUES (1, '184 COG');

INSERT INTO members (person_id, unit_id, password)
VALUES (2,1,'password');

INSERT INTO members (person_id, unit_id, password)
VALUES (3,1,'password');

INSERT INTO members (person_id, unit_id, password)
VALUES (4,1,'password');

INSERT INTO drills (wing_id, name, drill_start_date, drill_end_date)
VALUES (1, 'January 2023', '2023-01-07', '2023-01-08');

INSERT INTO hotels (name, address, city, state, zip, phone_number, email)
VALUES ('Crowne Plaza', '1015 Elm St', 'Dallas', 'TX', 75202, 2147425678, 'crown.plaza@gmail.com');

INSERT Into reservations(member_id, drill_id, hotel_id, res_num, res_start_date, res_end_date)
VALUES (1, 1, 1, 'CrownePlaza20230106', '2023-01-06', '2023-01-08');

INSERT Into reservations(member_id, drill_id, hotel_id, res_num, res_start_date, res_end_date)
VALUES (2, 1, 1, 'CrownePlaza20230106', '2023-01-06', '2023-01-08');

INSERT Into reservations(member_id, drill_id, hotel_id, res_num, res_start_date, res_end_date)
VALUES (3, 1, 1, 'CrownePlaza20230106', '2023-01-06', '2023-01-08');
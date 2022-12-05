CREATE DATABASE IF NOT EXISTS lodging;

USE lodging;

CREATE TABLE IF NOT EXISTS persons(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(200) NOT NULL,
    lastName VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    phoneNumber INT(10) NOT NULL UNIQUE,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS wings(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    wingName VARCHAR(200) NOT NULL UNIQUE,
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
    unitName VARCHAR(200) NOT NULL UNIQUE,
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
    drillStartDate DATE NOT NULL,
    drillEndDate DATE NOT NULL,
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
    phoneNumber INT(10) NOT NULL UNIQUE,
    email VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS reservations(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    member_id INT UNSIGNED NOT NULL,
    drill_id INT UNSIGNED NOT NULL,
    hotel_id INT UNSIGNED NOT NULL,
    res_num VARCHAR(200) NOT NULL,
    resStartDate DATE,
    resEndDate Date,
    PRIMARY KEY (id),
    FOREIGN KEY (member_id) REFERENCES members(id),
    FOREIGN KEY (drill_id) REFERENCES drills(id),
    FOREIGN KEY (hotel_id) REFERENCES hotels(id)
    );


INSERT INTO persons (firstName, lastName, email, phoneNumber)
VALUES (
        'John', 'Doe', 'john.doe@codeup.com', 1234567890
       );
INSERT INTO persons (firstName, lastName, email, phoneNumber)
VALUES (
           'Bob', 'White', 'bob.white@codeup.com', 1234567891
       );
INSERT INTO persons (firstName, lastName, email, phoneNumber)
VALUES (
           'Bob', 'Blue', 'bob.blue@codeup.com', 1234567892
       );
INSERT INTO persons (firstName, lastName, email, phoneNumber)
VALUES (
           'Bob', 'Green', 'bob.green@codeup.com', 1234567893
       );

INSERT INTO wings (wingName, state) VALUES ('184th Wing', 'TX');

INSERT INTO admins (person_id, wing_id, password)
VALUES (1,1,'password');

INSERT INTO units (wing_id, unitName)
VALUES (1, '184 COG');

INSERT INTO members (person_id, unit_id, password)
VALUES (2,1,'password');

INSERT INTO members (person_id, unit_id, password)
VALUES (3,1,'password');

INSERT INTO members (person_id, unit_id, password)
VALUES (4,1,'password');

INSERT INTO drills (wing_id, name, drillStartDate, drillEndDate)
VALUES (1, 'January 2023', '2023-01-07', '2023-01-08');

INSERT INTO hotels (name, address, city, state, zip, phoneNumber, email)
VALUES ('Crowne Plaza', '1015 Elm St', 'Dallas', 'TX', 75202, 2147425678, 'crown.plaza@gmail.com');

INSERT Into reservations(member_id, drill_id, hotel_id, res_num, resStartDate, resEndDate)
VALUES (1, 1, 1, 'CrownePlaza20230106', '2023-01-06', '2023-01-08');

INSERT Into reservations(member_id, drill_id, hotel_id, res_num, resStartDate, resEndDate)
VALUES (2, 1, 1, 'CrownePlaza20230106', '2023-01-06', '2023-01-08');

INSERT Into reservations(member_id, drill_id, hotel_id, res_num, resStartDate, resEndDate)
VALUES (3, 1, 1, 'CrownePlaza20230106', '2023-01-06', '2023-01-08');
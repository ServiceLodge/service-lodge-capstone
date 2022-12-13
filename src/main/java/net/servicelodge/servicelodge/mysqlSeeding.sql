#CREATE DATABASE IF NOT EXISTS lodging_db;

USE service_lodge;
# DROP TABLE IF EXISTS users, wings, units, drills, hotels, reservations;
#
# CREATE TABLE IF NOT EXISTS wings(
#     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
#     wing_name VARCHAR(100) NOT NULL UNIQUE,
#     state VARCHAR(2) NOT NULL,
#     PRIMARY KEY (id)
# );
#
# CREATE TABLE IF NOT EXISTS units(
#     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
#     wing_id INT UNSIGNED NOT NULL,
#     unit_name VARCHAR(100) NOT NULL UNIQUE,
#     PRIMARY KEY (id),
#     FOREIGN KEY (wing_id) REFERENCES wings(id)
# );
#
# CREATE TABLE IF NOT EXISTS users(
#     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
#     first_name VARCHAR(100) NOT NULL,
#     last_name VARCHAR(100) NOT NULL,
#     username VARCHAR(100) NOT NULL UNIQUE,
#     password VARCHAR(100) NOT NULL,
#     phone_number VARCHAR(20) NOT NULL UNIQUE,
#     unit_id INT UNSIGNED,
#     is_admin BOOLEAN NOT NULL,
#     PRIMARY KEY (id),
#     FOREIGN KEY (unit_id) REFERENCES units(id)
# );
#
# CREATE TABLE IF NOT EXISTS drills(
#     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
#     wing_id INT UNSIGNED NOT NULL,
#     name VARCHAR(100) NOT NULL UNIQUE,
#     drill_start_date DATE NOT NULL,
#     drill_end_date DATE NOT NULL,
#     PRIMARY KEY (id),
#     FOREIGN KEY (wing_id) REFERENCES wings(id)
# );
#
# CREATE TABLE IF NOT EXISTS hotels(
#     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
#     name VARCHAR(255) NOT NULL UNIQUE,
#     address VARCHAR(100) NOT NULL UNIQUE,
#     city VARCHAR(100) NOT NULL,
#     state VARCHAR(2) NOT NULL,
#     zip INT(7) NOT NULL,
#     phone_number VARCHAR(20) NOT NULL UNIQUE,
#     PRIMARY KEY (id)
# );
#
# CREATE TABLE IF NOT EXISTS reservations(
#     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
#     user_id INT UNSIGNED NOT NULL,
#     drill_id INT UNSIGNED NOT NULL,
#     hotel_id INT UNSIGNED NOT NULL,
#     res_num VARCHAR(100) NOT NULL,
#     PRIMARY KEY (id),
#     FOREIGN KEY (user_id) REFERENCES users(id),
#     FOREIGN KEY (drill_id) REFERENCES drills(id),
#     FOREIGN KEY (hotel_id) REFERENCES hotels(id)
# );

INSERT INTO wings (wing_name, state) VALUES ('184th Wing', 'KS');

INSERT INTO units (wing_id, unit_name)
VALUES (1, '184 COG'),
       (1, '127 COS'),
       (1, '177 IAS'),
       (1, '299 NOS');


INSERT INTO users (first_name, last_name, username, password, phone_number, unit_id, is_admin)
VALUES ('Cody', 'Palmer', 'cody@codeup.com', '$2a$10$w5dkTf7EwDX4UMPtmere/uCWDKwgsQ/F9LGr0QemE2EYilb98BaZe', '(123) 456-7812', 1, false),
       ('Cristian', 'Almendarez', 'cristian@codeup.com', '$2a$10$WqTVhtLRLjN3z4OkIfv0nO1BkaGXArBvAjQeN5aRr0u87tAYcQUfu', '(123) 456-7891', 2, false),
       ('Julian', 'Gutierrez', 'julian@codeup.com', '$2a$10$fx4KEESJKk8T4K5r1sjmle/vCFhbLQ6U4qgq.owxfU4Y2QCZprkpq', '(123) 456-7892', 3, false),
       ('Mia', 'Evans', 'mia@codeup.com', '$2a$10$8kcQjTfHozPtoOXSt8efXeD3jE5IOT3lkXuNkCKRaPl2kZt5wT7He', '(123) 456-7893', 4, false),
       ('Jay', 'Arredondo', 'jay@codeup.com', '$2a$10$8kcQjTfHozPtoOXSt8efXeD3jE5IOT3lkXuNkCKRaPl2kZt5wT7He', '(123) 456-7803', 1, true);

INSERT INTO drills (wing_id, name, drill_start_date, drill_end_date)
VALUES (1, 'January 2023', '2023-01-07', '2023-01-08'),
       (1, 'February 2023', '2023-02-04', '2023-02-05'),
       (1, 'March 2023', '2023-03-04', '2023-03-05'),
       (1, 'April 2023', '2023-04-01', '2023-04-02'),
       (1, 'May 2023', '2023-05-06', '2023-05-07'),
       (1, 'June 2023', '2023-06-03', '2023-06-06'),
       (1, 'August 2023', '2023-08-05', '2023-08-06'),
       (1, 'September 2023', '2023-09-09', '2023-09-10'),
       (1, 'October 2023', '2023-10-14', '2023-10-15'),
       (1, 'November 2023', '2023-11-04', '2023-11-05'),
       (1, 'December 2023', '2023-12-02', '2023-12-03');

INSERT INTO hotels (name, address, city, state, zip, phone_number)
VALUES ('Wichita Marriott', '9100 E Corporate Hills Dr', 'Wichita', 'KS', 67207, '(316) 651-0333'),
       ('Hyatt Regency Wichita', '400 W Waterman St', 'Wichita', 'KS', 67202, '(316) 293-1234'),
       ('Home2 Suites by Hilton Wichita Northeast', '2102 N Crossmark Pl', 'Wichita', 'KS', 67206, '(316) 634-8308'),
       ('Aloft Wichita', '3642 Oliver', 'Wichita', 'KS', 67220, '(316) 744-1100');

INSERT Into reservations(user_id, drill_id, hotel_id, res_num)
VALUES (1, 1, 4, '89DIEIV892JC280'),
       (1, 2, 3, 'HD4KEIV892JC299'),
       (2, 1, 1, '4IOFUSV892JS742'),
       (2, 2, 3, 'C3UO9367DJUGLS9'),
       (2, 3, 2, 'JD937FUSL837FTD'),
       (3, 1, 1, 'DSJFG89EIJWARD3'),
       (3, 2, 4, 'C3UO9367DJUGLS9'),
       (4, 1, 2, '83985MV9SMAV4BG'),
       (4, 2, 1, '83KD0PEUSJAV4JU'),
       (4, 3, 1, 'KOI9HWS9SMAV70O'),
       (4, 4, 1, 'JIEURH35TSDF543');


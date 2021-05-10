CREATE DATABASE wildlife_tracker
\c wildlife_tracker
CREATE TABLE rangers (id serial PRIMARY KEY, name VARCHAR, badge_number INT,phone_number int,email VARCHAR);
CREATE TABLE common_animals(id serial PRIMARY KEY,type VARCHAR, name varchar, age VARCHAR);
CREATE TABLE endangered_animals(id serial PRIMARY KEY,type VARCHAR, name varchar, age VARCHAR, health VARCHAR);
CREATE TABLE locations (id serial PRIMARY KEY,name VARCHAR);
CREATE TABLE sightings (id serial PRIMARY KEY,ranger_id INT, animal_id INT, location_id INT,time TIMESTAMP);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
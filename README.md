# WILDLIFE TRACKER APP

## Project Description

<p>Wildlife Tracker is an application that enables rangers to record sightings in an area.</p>

<p>The application was created for Forest Service, a company that is considering to clearcut a nearby forest.</p>

<p>It enables a user to record details of the ranger, spotted animal and location.</p>

<p>The records are saved in a database.</p>

## User Stories

1. As a user, i want to see a welcome page that includes where i can go and what i can do.
2. As  a user i want to be able to navigate through the website with ease.
3. As a user i want to be able to record a sighting, ranger, location or animal.
4. As a user i want to be able to modify any details that i may have recorded.
5. As a user i want to be able to delete any details that i may have recorded.
6. As a user i want to be able to see all the details of sightings recorded by me and/or other users.

## Author's Information

<p>This project was developed by Emmanuela Joy.</p>

Click on [Emmanuela Joy ](https://github.com/EmmanuelaJoy) to find the link to her Github Site.

## Demo

Here is a working live demo : https://heroes-assemble.herokuapp.com/

## Project Set Up Instructions

To set up this project:
- Clone the repository by executing the following command in your terminal in the directory of your choice - `git clone https://github.com/EmmanuelaJoy/hero-squad.git`
- Navigate into the wildlife-tracker directory - `cd wildlife-tracker`
- Run `gradle build` to build the project.

## Database Set Up Instructions

To set up the database:
- Run `psql` in the project terminal.
- Type the command: `CREATE DATABASE wildlife_tracker;`
- Navigate into the database by typing the command: `\c wildlife_tracker;`
- Create the required tables by running the following commands:
    - `CREATE TABLE rangers (id serial PRIMARY KEY, name VARCHAR, badge_number INT,phone_number int,email VARCHAR);`
  - `CREATE TABLE common_animals(id serial PRIMARY KEY,type VARCHAR, name varchar, age VARCHAR);`
  - `CREATE TABLE endangered_animals(id serial PRIMARY KEY,type VARCHAR, name varchar, age VARCHAR, health VARCHAR);`
  - `CREATE TABLE locations (id serial PRIMARY KEY,name VARCHAR);`
  - `CREATE TABLE sightings (id serial PRIMARY KEY,ranger_id INT, animal_id INT, location_id INT,time TIMESTAMP);`
- Create a test database by typing the command: `CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;`

## Technologies Used:

- Java.
- Javascript.
- Spark.
- Gradle.
- Maven.
- Handlebars.
- CSS.
- Bootstrap.
- Sql2o.
- JUnit.


## Contact Information

- Email : emmajoy81@gmail.com
- Phone : +254 725853727

## [License](https://github.com/EmmanuelaJoy/githubSearch/blob/main/LICENSE)

MIT © [Emmanuela Joy ](https://github.com/EmmanuelaJoy)

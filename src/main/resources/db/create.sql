SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS rangers(
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    badge_number VARCHAR,
    phone_number int,
    email VARCHAR
)


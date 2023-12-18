CREATE TABLE IF NOT EXISTS "division"
(
    division_id SERIAL primary key,
    division_name VARCHAR(255) NOT NULL,
    original_division_name VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL
);
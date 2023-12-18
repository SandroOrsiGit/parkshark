CREATE TABLE IF NOT EXISTS "manager"

(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE  IF NOT EXISTS "postal_code"
(
    postal_code_id SERIAL PRIMARY KEY,
    postal_code    VARCHAR(255) NOT NULL,
    location       VARCHAR(255) NOT NULL

);

CREATE TABLE  IF NOT EXISTS "address"
(
    address_id        SERIAL PRIMARY KEY,
    street_name       VARCHAR(255) NOT NULL,
    street_number     VARCHAR(255) NOT NULL,
    fk_postal_code_id INTEGER      NOT NULL,

    CONSTRAINT  IF NOT EXISTS fk_postal_code
        FOREIGN KEY (fk_postal_code_id)
            REFERENCES postal_code (postal_code_id)
);

CREATE TABLE  IF NOT EXISTS "contact_person"
(
    contact_person_id   SERIAL PRIMARY KEY,
    name                VARCHAR(255) NOT NULL,
    mobile_phone_number VARCHAR(20),
    telephone_number    VARCHAR(20),
    email               VARCHAR(255) NOT NULL,
    fk_address_id       INTEGER      NOT NULL,

    CONSTRAINT  IF NOT EXISTS either_mobile_or_telephone_number CHECK (
            mobile_phone_number IS NOT NULL OR telephone_number IS NOT NULL
        ),
    CONSTRAINT  IF NOT EXISTS fk_address
        FOREIGN KEY  (fk_address_id)
            REFERENCES address (address_id)
);



CREATE TABLE  IF NOT EXISTS "parking_lot"
(
    parking_lot_id       SERIAL PRIMARY KEY,
    name                 VARCHAR(255)     NOT NULL,
    category             VARCHAR(255)     NOT NULL,
    max_capacity         INTEGER          NOT NULL,
    price_per_hour       DOUBLE PRECISION NOT NULL,
    fk_address_id        INTEGER          NOT NULL,

    CONSTRAINT  IF NOT EXISTS fk_address
        FOREIGN KEY (fk_address_id)
            REFERENCES address (address_id)
);

CREATE TABLE  IF NOT EXISTS "parking_lot_contact_person"
(
    fk_parking_lot_id    INTEGER NOT NULL,
    fk_contact_person_id INTEGER NOT NULL,

    CONSTRAINT  IF NOT EXISTS fk_parking_lot
        FOREIGN KEY (fk_parking_lot_id)
            REFERENCES parking_lot (parking_lot_id),
    CONSTRAINT  IF NOT EXISTS fk_contact_person
        FOREIGN KEY (fk_contact_person_id)
            REFERENCES contact_person (contact_person_id)
);

CREATE TABLE IF NOT EXISTS "division"
(
    division_id            SERIAL PRIMARY KEY,
    division_name          VARCHAR(255) NOT NULL,
    original_division_name VARCHAR(255) NOT NULL,
    director               VARCHAR(255) NOT NULL,
    parent_division_id     INTEGER
        CONSTRAINT fk_parent_id
            REFERENCES division
);

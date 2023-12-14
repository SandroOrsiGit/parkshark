CREATE TABLE "postal_code"
(
    postal_code_id SERIAL PRIMARY KEY,
    postal_code    VARCHAR(255) NOT NULL,
    location       VARCHAR(255) NOT NULL

);

CREATE TABLE "address"
(
    address_id        SERIAL PRIMARY KEY,
    street_name       VARCHAR(255) NOT NULL,
    street_number     VARCHAR(255) NOT NULL,
    fk_postal_code_id INTEGER      NOT NULL,

    CONSTRAINT fk_postal_code
        FOREIGN KEY (fk_postal_code_id)
            REFERENCES postal_code (postal_code_id)
);

CREATE TABLE "contact_person"
(
    contact_person_id   SERIAL PRIMARY KEY,
    name                VARCHAR(255) NOT NULL,
    mobile_phone_number VARCHAR(20),
    telephone_number    VARCHAR(20),
    email               VARCHAR(255) NOT NULL,
    fk_address_id       INTEGER      NOT NULL,

    CONSTRAINT either_mobile_or_telephone_number CHECK (
        mobile_phone_number IS NOT NULL OR telephone_number IS NOT NULL
        ),
    CONSTRAINT fk_address
        FOREIGN KEY (fk_address_id)
            REFERENCES address (address_id)
);



CREATE TABLE "parking_lot"
(
    parking_lot_id       SERIAL PRIMARY KEY,
    name                 VARCHAR(255)     NOT NULL,
    category             VARCHAR(255)     NOT NULL,
    max_capacity         INTEGER          NOT NULL,
    price_per_hour       DOUBLE PRECISION NOT NULL,
    fk_address_id        INTEGER          NOT NULL,
    fk_contact_person_id INTEGER          NOT NULL,


    CONSTRAINT fk_contact_person
        FOREIGN KEY (fk_contact_person_id)
            REFERENCES contact_person (contact_person_id),
    CONSTRAINT fk_address
        FOREIGN KEY (fk_address_id)
            REFERENCES address (address_id)
);

CREATE TABLE "parking_lot_contact_person"
(
    fk_parking_lot_id    INTEGER NOT NULL,
    fk_contact_person_id INTEGER NOT NULL,

    CONSTRAINT fk_parking_lot
        FOREIGN KEY (fk_parking_lot_id)
            REFERENCES parking_lot (parking_lot_id),
    CONSTRAINT fk_contact_person
        FOREIGN KEY (fk_contact_person_id)
            REFERENCES contact_person (contact_person_id)

)
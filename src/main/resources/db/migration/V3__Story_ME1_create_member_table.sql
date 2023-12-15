
CREATE TABLE "member"
(
    member_id SERIAL primary key,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    fk_address_id       INTEGER      NOT NULL,
    telephone_number VARCHAR(255) NOT NULL,
    email_address VARCHAR(255) NOT NULL,
    license_plate_number VARCHAR(255) NOT NULL,
    license_plate_country VARCHAR(255) NOT NULL,
    registration_date DATE NOT NULL,

    CONSTRAINT fk_address
        FOREIGN KEY (fk_address_id)
            REFERENCES address (address_id)

);
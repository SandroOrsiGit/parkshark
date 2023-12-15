INSERT INTO MANAGER (username, password)
values ('Test', 'Test');

INSERT INTO postal_code(postal_code, location)
VALUES ('1234', 'Testinglocation1');

INSERT INTO address(street_name, street_number, fk_postal_code_id)
VALUES ('StreetName', 'StreetNumber', 1);

INSERT INTO contact_person(name, mobile_phone_number, telephone_number, email, fk_address_id)
VALUES('Test Subject', '0545667788', null, 'test@testing.com', 1);

INSERT INTO parking_lot(name, category, max_capacity, price_per_hour, fk_address_id)
VALUES('ParkingLotName', 'ABOVE_GROUND_BUILDING', 2000, 4.5, 1);

INSERT INTO parking_lot_contact_person(fk_parking_lot_id, fk_contact_person_id)
VALUES(1, 1);




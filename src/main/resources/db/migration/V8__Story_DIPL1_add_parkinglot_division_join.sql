ALTER TABLE parking_lot
ADD COLUMN fk_division_id INTEGER;

ALTER TABLE parking_lot
ADD CONSTRAINT fk_division_id
    FOREIGN KEY (fk_division_id)
            REFERENCES division (division_id)
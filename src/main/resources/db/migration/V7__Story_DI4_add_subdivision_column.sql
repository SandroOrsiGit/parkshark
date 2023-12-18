ALTER TABLE division
    ADD COLUMN "parent_division_id" INTEGER;

ALTER TABLE division
ADD CONSTRAINT fk_parent_id
FOREIGN KEY (parent_division_id) REFERENCES division(division_id);
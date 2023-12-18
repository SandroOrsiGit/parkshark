UPDATE member
SET "membership_level" = 'BRONZE';

ALTER TABLE member
ALTER COLUMN "membership_level" SET NOT NULL;
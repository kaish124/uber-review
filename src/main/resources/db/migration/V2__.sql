ALTER TABLE em_booking
DROP
CONSTRAINT fk4afmgdxryo44tatoprhm9bttu;

ALTER TABLE em_booking_review
    ADD booking_id BIGINT;

ALTER TABLE em_booking_review
    ADD CONSTRAINT FK_EM_BOOKING_REVIEW_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES em_booking (id);

ALTER TABLE em_booking
DROP
COLUMN review_id;

ALTER TABLE em_booking
DROP
COLUMN total_duration;

DROP SEQUENCE em_booking_review_seq CASCADE;

ALTER TABLE em_booking
    ADD total_duration BIGINT;
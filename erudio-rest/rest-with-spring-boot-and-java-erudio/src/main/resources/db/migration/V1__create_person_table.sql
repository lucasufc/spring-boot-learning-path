CREATE TABLE person (
    id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(80) NOT NULL,
    last_name VARCHAR(80) NOT NULL,
    gender VARCHAR(6) NOT NULL,
    PRIMARY KEY (id)
);

CREATE INDEX idx_person_last_name ON person(last_name);
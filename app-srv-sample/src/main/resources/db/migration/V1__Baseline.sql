CREATE TABLE feature_toggle (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    key_name VARCHAR(30) UNIQUE,
    enabled BOOLEAN
);

INSERT INTO feature_toggle (key_name, enabled)
VALUES ('FIRST_FEATURE', false);
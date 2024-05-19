CREATE TABLE feature_toggle (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    key_name VARCHAR(30),
    enabled BOOLEAN
);
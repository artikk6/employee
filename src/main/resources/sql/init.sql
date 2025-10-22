CREATE TABLE IF NOT EXISTS employee
(
    id        BIGSERIAL PRIMARY KEY,
    firstname VARCHAR(255)          DEFAULT 'employee',
    lastname  VARCHAR(255)          DEFAULT 'company',
    username  VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    role      VARCHAR(255) NOT NULL default 'USER',
    birthday  DATE,
    salary    DECIMAL(10, 2)
);


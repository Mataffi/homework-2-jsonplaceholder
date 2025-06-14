CREATE TABLE geo
(
    id  BIGSERIAL PRIMARY KEY,
    lat VARCHAR(255) NOT NULL,
    lng VARCHAR(255) NOT NULL
);

CREATE TABLE addresses
(
    id      BIGSERIAL PRIMARY KEY,
    street  VARCHAR(255) NOT NULL,
    suite   VARCHAR(255) NOT NULL,
    city    VARCHAR(255) NOT NULL,
    zipcode VARCHAR(255) NOT NULL,
    geo_id  BIGINT UNIQUE,
    CONSTRAINT fk_geo FOREIGN KEY (geo_id) REFERENCES geo (id) ON DELETE CASCADE
);

CREATE TABLE companies
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    catch_phrase VARCHAR(255) NOT NULL,
    bs           VARCHAR(255) NOT NULL
);

CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255)        NOT NULL,
    username   VARCHAR(255) UNIQUE NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    phone      VARCHAR(255)        NOT NULL,
    website    VARCHAR(255)        NOT NULL,
    address_id BIGINT UNIQUE,
    company_id BIGINT UNIQUE,
    CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES addresses (id) ON DELETE CASCADE,
    CONSTRAINT fk_company FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE
);

CREATE TABLE auth_users
(
    id            BIGSERIAL PRIMARY KEY,
    email         VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255)        NOT NULL
);
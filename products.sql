DROP DATABASE IF EXISTS products_db;
CREATE DATABASE products_db;
USE products_db;

DROP TABLE IF EXISTS products_table;
CREATE TABLE products_table(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    url VARCHAR(50) NOT NULL,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);
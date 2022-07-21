DROP DATABASE IF EXISTS comments_db;
CREATE DATABASE comments_db;
USE comments_db;

DROP TABLE IF EXISTS comments_table;
CREATE TABLE comments_table(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    url VARCHAR(100) NOT NULL,
    comment VARCHAR(300) NOT NULL,
    PRIMARY KEY (id)
);

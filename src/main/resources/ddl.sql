create database if not exists notes1 DEFAULT CHARACTER SET utf8;

use notes1;

CREATE TABLE Role
(
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    role VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE User
(
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    role_id INT(11) NOT NULL,
    FOREIGN KEY (role_id) REFERENCES Role (id) ON DELETE CASCADE
);
CREATE INDEX role_id ON User (role_id);

CREATE TABLE Note
(
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    note_date DATETIME NOT NULL,
    title VARCHAR(70) NOT NULL,
    category VARCHAR(30) NOT NULL,
    description VARCHAR(1500) NOT NULL,
    user_id INT(11) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User (id) on DELETE CASCADE
);
CREATE INDEX user_id ON note (user_id);
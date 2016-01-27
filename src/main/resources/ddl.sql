DROP DATABASE IF EXISTS notes;
create database if not exists notes DEFAULT CHARACTER SET utf8;
use notes;

CREATE TABLE Note
(
    id INT(11) PRIMARY KEY NOT NULL,
    note_date DATETIME NOT NULL,
    title VARCHAR(70) NOT NULL,
    category VARCHAR(30) NOT NULL,
    description VARCHAR(1500) NOT NULL
);

CREATE TABLE Note_User
(
    id INT(11) PRIMARY KEY NOT NULL,
    note_id INT(11) NOT NULL,
    user_id INT(11) NOT NULL,
    CONSTRAINT note_user_ibfk_1 FOREIGN KEY (note_id) REFERENCES Note (id),
    CONSTRAINT note_user_ibfk_2 FOREIGN KEY (user_id) REFERENCES User (id)
);
CREATE INDEX note_id ON Note_User (note_id);
CREATE INDEX user_id ON Note_User (user_id);

CREATE TABLE Role
(
    id INT(11) PRIMARY KEY NOT NULL,
    role VARCHAR(20) NOT NULL
);
CREATE UNIQUE INDEX role ON Role (role);

CREATE TABLE User
(
    id INT(11) PRIMARY KEY NOT NULL,
    login VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    role_id INT(11) NOT NULL,
    CONSTRAINT fk_UserRole FOREIGN KEY (role_id) REFERENCES Role (role)
);
CREATE INDEX fk_UserRole ON User (role_id);
CREATE UNIQUE INDEX login ON User (login);
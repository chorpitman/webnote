create database if not exists notes1 DEFAULT CHARACTER SET utf8;

use notes1;

CREATE TABLE Role
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE User
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    login VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    role_id INT(11) NOT NULL,
    FOREIGN KEY (role_id) REFERENCES Role (id) ON DELETE CASCADE
);
CREATE INDEX role_id ON User (role_id);

CREATE TABLE Note
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    note_date DATETIME NOT NULL,
    title VARCHAR(70) NOT NULL,
    category VARCHAR(30) NOT NULL,
    description VARCHAR(1500) NOT NULL,
    user_id INT(11) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User (id) on DELETE CASCADE
);
CREATE INDEX user_id ON note (user_id);

INSERT INTO `notes1`.`Role` (`id`, `role`) VALUES ('1', 'admin');
INSERT INTO `notes1`.`Role` (`id`, `role`) VALUES ('2', 'user');
INSERT INTO `notes1`.`Role` (`id`, `role`) VALUES ('3', 'superuser');

INSERT INTO `notes1`.`User` (`id`, `login`, `password`, `role_id`) VALUES ('1', 'admin', 'a', '1');
INSERT INTO `notes1`.`User` (`id`, `login`, `password`, `role_id`) VALUES ('2', 'user', 'u', '2');
INSERT INTO `notes1`.`User` (`id`, `login`, `password`, `role_id`) VALUES ('3', 'suser', 's', '3');

INSERT INTO `notes1`.`Note` (`id`, `note_date`, `title`, `category`, `description`, `user_id`) VALUES ('1', '2016-01-01', 'adminTitle', 'main', 'qazxcvwssdf', '1');
INSERT INTO `notes1`.`Note` (`id`, `note_date`, `title`, `category`, `description`, `user_id`) VALUES ('2', '2016-01-02', 'adminTime', 'main', 'qazxcvwssdf', '1');
INSERT INTO `notes1`.`Note` (`id`, `note_date`, `title`, `category`, `description`, `user_id`) VALUES ('3', '2016-01-03', 'adminTitle', 'general', 'qwe', '1');
INSERT INTO `notes1`.`Note` (`id`, `note_date`, `title`, `category`, `description`, `user_id`) VALUES ('4', '2016-01-04', 'userTitle', 'general', 'qwe', '2');
INSERT INTO `notes1`.`Note` (`id`, `note_date`, `title`, `category`, `description`, `user_id`) VALUES ('5', '2016-01-04', 'userTitle', 'general', 'qwe', '2');
INSERT INTO `notes1`.`Note` (`id`, `note_date`, `title`, `category`, `description`, `user_id`) VALUES ('6', '2016-01-04', 'superUserTitle', 'general', 'qwe', '3');

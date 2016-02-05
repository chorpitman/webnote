use notes1;

INSERT INTO Role (role) VALUES ('admin');
INSERT INTO Role (role) VALUES ('user');
INSERT INTO Role (role) VALUES ('superuser');

INSERT INTO User (login, password, role_id) VALUES ('admin', 'a', 1);
INSERT INTO User (login, password, role_id) VALUES ('user', 'u', 2);
INSERT INTO User (login, password, role_id) VALUES ('suser', 's', 3);

INSERT INTO Note (note_date, title, category, description, user_id) VALUES ('2016-01-01', 'adminTitle', 'main', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit', 1);
INSERT INTO Note (note_date, title, category, description, user_id) VALUES ('2016-01-02', 'adminTime', 'main', 'Lorem ipsum dolor sit amet', 1);
INSERT INTO Note (note_date, title, category, description, user_id) VALUES ('2016-01-03', 'adminTitle', 'general', 'Lorem ipsum dolor', 1);
INSERT INTO Note (note_date, title, category, description, user_id) VALUES ('2016-01-04', 'userTitle', 'general', 'Lorem ipsum', 2);
INSERT INTO Note (note_date, title, category, description, user_id) VALUES ('2016-01-04', 'userTitle', 'general', 'Lorem ipsum dol', 2);
INSERT INTO Note (note_date, title, category, description, user_id) VALUES ('2016-01-04', 'superUserTitle', 'general', 'Lorem ipsum dolor sit a', 3);

INSERT INTO company ( name, description)
values ('Danza SL', 'Some description');


INSERT INTO users (full_name, password, email, mobile_number, id_company)
values ( 'Isagani Quinto', 'isaquinto', 'isaquinto@uoc.edu', '600075567', 1),
 ('Sabrina Alejandra Quintanilla', 'saquintanilla', 'saquintanilla@uoc.edu', '600075567', null),
 ('Cristian Daza Povedano', 'cdazap', 'cdazap@uoc.edu', '600075567', null);

INSERT INTO roles (name, description)
values ('ROLE_ADMINISTRATOR', 'admin'),
 ('ROLE_ORGANIZER', 'organizer'),
 ('ROLE_USER', 'user');

INSERT INTO user_roles (user_id, role_id)
values (1, 1),
 (1, 3),
 (2, 1),
 (3, 3);






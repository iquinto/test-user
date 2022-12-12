INSERT INTO company ( name, description)
values ('Eureka SL', 'Group 2 PDS'),
  ('Dance Club  SL', 'Some description');


INSERT INTO users (full_name, password, email, mobile_number, id_company)
values ('Isagani Quinto', '$2a$10$xzYpKFy48SanpwyfxPp/p.lqQDHaeCBgZjm/xgpc74CGzIBUftffy', 'isaquinto@uoc.edu', '600075567', 1),
        ('Sabrina Alejandra Quintanilla', '$2a$10$xzYpKFy48SanpwyfxPp/p.lqQDHaeCBgZjm/xgpc74CGzIBUftffy', 'saquintanilla@uoc.edu', '600075567', 1),
        ('Cristian Daza Povedano', '$2a$10$xzYpKFy48SanpwyfxPp/p.lqQDHaeCBgZjm/xgpc74CGzIBUftffy', 'cdazap@uoc.edu', '600075567', 1),
        ('Daniel Cardesa Marco', '$2a$10$xzYpKFy48SanpwyfxPp/p.lqQDHaeCBgZjm/xgpc74CGzIBUftffy', 'dcardesa@uoc.edu', '600075567', 1),
        ('German Lizondo Perez', '$2a$10$xzYpKFy48SanpwyfxPp/p.lqQDHaeCBgZjm/xgpc74CGzIBUftffy', 'germanlizondo@uoc.edu', '600075567', 1),
        ('Jeronimo Lopez Ledesma', '$2a$10$xzYpKFy48SanpwyfxPp/p.lqQDHaeCBgZjm/xgpc74CGzIBUftffy', 'jlopezled@uoc.edu', '600075567', 1),
        ('Micheal Gradin', '$2a$10$xzYpKFy48SanpwyfxPp/p.lqQDHaeCBgZjm/xgpc74CGzIBUftffy', 'buyer@gmail.com', '600075567', null),
        ('Jhon Joe', '$2a$10$xzYpKFy48SanpwyfxPp/p.lqQDHaeCBgZjm/xgpc74CGzIBUftffy', 'organizer@gmail.com', '600075567', 2);


INSERT INTO roles (name, description)
values ('ROLE_ADMINISTRATOR', 'admin'),
        ('ROLE_ORGANIZER', 'organizer'),
        ('ROLE_USER', 'user');

INSERT INTO user_roles (user_id, role_id)
values (1, 1),(1, 2),(1, 3),
       (2, 1), (2, 2),(2, 3),
       (3, 1), (3, 2),(3, 3),
       (4, 1), (4, 2),(4, 3),
       (5, 1), (5, 2),(5, 3),
       (6, 1), (6, 2),(6, 3),
       (7, 3), (8, 2);




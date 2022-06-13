create table users(id bigint auto_increment PRIMARY KEY, user_name varchar(50), email varchar(50), password varchar(50));
insert into users(user_name, email, password) values ('Péter', 'hadikp@gmail.com', 'pass');
insert into users(user_name, email, password) values ('Gergő', 'tothg@gmail.com', 'pass1234');
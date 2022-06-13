create table trainings(id bigint auto_increment PRIMARY KEY, name varchar(50), description varchar(50), training_date date , user_id bigint);
insert into trainings(name, description, training_date, user_id) values ('futás', 'Péter hosszú futása', '2022-02-23', 1);
insert into trainings(name, description, training_date, user_id) values ('futás', 'Gergő laza kocogása', '2022-02-24', 2);
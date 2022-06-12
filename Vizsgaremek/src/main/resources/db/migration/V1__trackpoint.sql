create table trackpoints(id bigint auto_increment PRIMARY KEY, name varchar(50), elevation double, coordinate_id bigint, training_id bigint);
insert into trackpoints(name, elevation, coordinate_id, training_id) values ('emokeC', 2.3, 1, 1);

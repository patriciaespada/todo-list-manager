create database todolistmanager;
use todolistmanager;
create table todo_list(
	todo_list_id int not null auto_increment, 
    todo_list_name varchar(100) not null,
    todo_list_created_time datetime not null default CURRENT_TIMESTAMP,
    todo_list_closed_time datetime default null,
	primary key(todo_list_id)
);
create table todo(
	todo_id int not null auto_increment,
    todo_list_id int not null,
    todo_name varchar(100) not null, 
    todo_priority varchar(20),
    todo_status varchar(20),
    todo_created_time datetime not null default CURRENT_TIMESTAMP,
    todo_closed_time datetime default null,
	primary key(todo_id),
	foreign key (todo_list_id) REFERENCES todo_list(todo_list_id)
);

insert into todo_list values (1,'First Todo List',curtime(),null);
insert into todo values (1,1,'First Todo in the First Todo List','LOW','ACTIVE',curtime(),null);
insert into todo values (2,1,'Second Todo in the First Todo List','MEDIUM','ACTIVE',curtime(),null);
insert into todo values (3,1,'Third Todo in the First Todo List','HIGH','COMPLETED',curtime(),null);

insert into todo_list values (2,'Second Todo List',curtime(),null);
insert into todo values (4,2,'First Todo in the Second Todo List','LOW','ACTIVE',curtime(),null);
insert into todo values (5,2,'Second Todo in the Second Todo List','MEDIUM','ACTIVE',curtime(),null);
insert into todo values (6,2,'Third Todo in the Second Todo List','HIGH','COMPLETED',curtime(),null);

select * from todo_list tl, todo t where t.todo_list_id = tl.todo_list_id;
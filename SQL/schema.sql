DROP DATABASE IF EXISTS `WebPeople`;

CREATE DATABASE `WebPeople`;

create table WebPeople.Person (
	person_id int not null auto_increment, #primary
    username varchar(30),
	password varchar(30),
    primary key (person_id)
);

create table WebPeople.Person_info (
	info_id int not null auto_increment, #primary 
    person_id int not null,
    name varchar(50),
    age int,
    hobbies varchar(500),
	primary key (info_id),
    foreign key (person_id) references WebPeople.Person(person_id)
);

create table WebPeople.Class (
	class_id int not null auto_increment, #primary 
    info_id int not null,
    class varchar(20),
    grade int,
    primary key (class_id),
    foreign key (info_id) references WebPeople.Person_info(info_id)
);

create table WebPeople.Test (
	test_id int not null auto_increment, #primary
    class_id int not null,
    chapter int,
    grade int,
    primary key (test_id),
    foreign key (class_id) references WebPeople.Class(class_id)
);

#Person1
insert into WebPeople.Person (username, password)
values ("Steven23", "hunter2");
#-Info1
insert into WebPeople.Person_info (person_id, name, age, hobbies)
values (1, "Steven Dunn", 16, "Video games, Eating pizza.");
#--Class1
insert into WebPeople.Class (info_id, class, grade)
values (1, "ECE201", "93");
#---Tests
insert into WebPeople.Test (class_id, chapter, grade)
values (1, 1, "89");
insert into WebPeople.Test (class_id, chapter, grade)
values (1, 2, "99");
insert into WebPeople.Test (class_id, chapter, grade)
values (1, 3, "98");
#--Class2
insert into WebPeople.Class (info_id, class, grade)
values (1, "ENG101", "84");
#---Tests
insert into WebPeople.Test (class_id, chapter, grade)
values (2, 1, "81");
insert into WebPeople.Test (class_id, chapter, grade)
values (2, 2, "85");

#Person2
insert into WebPeople.Person (username, password)
values ("LarryVampireSlayer", "yoboysteveharvey");
#-Info2
insert into WebPeople.Person_info (person_id, name, age, hobbies)
values (2, "George Redding", 23, "Bike riding, freelance web development, eating cakes.");
#--Class3
insert into WebPeople.Class (info_id, class, grade)
values (2, "EGR312", "95");
insert into WebPeople.Test (class_id, chapter, grade)
values (3, 1, "95");
insert into WebPeople.Test (class_id, chapter, grade)
values (3, 4, "100");
insert into WebPeople.Test (class_id, chapter, grade)
values(3, 5, "89");

#Person3
insert into WebPeople.Person (username, password)
values ("BubbleDestroyer", "passwerdpuffgurls3");
#-Info3
insert into WebPeople.Person_info (person_id, name, age, hobbies)
values (3, "Hellen Campbell", 20, "Destuction.");
#--Class4
insert into WebPeople.Class (info_id, class, grade)
values (3, "ENG102", "75");
insert into WebPeople.Test (class_id, chapter, grade)
values (4, 3, "75");
#--Class5
insert into WebPeople.Class (info_id, class, grade)
values (3, "MTH316", "97");
insert into WebPeople.Test (class_id, chapter, grade)
values (5, 10, "97");
#--Class6
insert into WebPeople.Class (info_id, class, grade)
values (3, "HST304", "87");
insert into WebPeople.Test (class_id, chapter, grade)
values (6, 4, "87");

#Join it all (oh boy)
select p.username, p.password, i.name, i.age, c.class, c.grade, t.chapter, t.grade
from WebPeople.Person p
	join WebPeople.Person_info i
		on p.person_id = i.person_id
	join WebPeople.Class c
		on i.info_id = c.info_id
	join WebPeople.Test t
		on c.class_id = t.class_id;

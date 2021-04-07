drop database if exists library;

create database library;

use library;

create table student(
	student_id varchar(15) primary key not null,
    student_name varchar(50) not null,
    address varchar(500),
    city varchar(50),
    country varchar(50),
    email varchar(50),
    student_pic varchar(100)
);

create table book_order(
	order_id varchar(15) primary key not null,
    fk_student_id varchar(15),
    foreign key (fk_student_id) references student (student_id)
);

create table book_category(
	book_category_id varchar(30) primary key not null,
    book_category_name varchar(30)
);

create table book(
	book_id varchar(20) primary key not null,
    book_name varchar(30),
    fk_book_category_id varchar(20),
    foreign key (fk_book_category_id) references book_category (book_category_id), 
    fk_order_id varchar(15),
	foreign key (fk_order_id) references book_order (order_id)
);

insert into student
values (1, 'Do Khoa', 'H29/54/K72 Dinh Tien Hoang', 'Da Nang', 'Viet Nam', 'abc@abc.abc', null),
(2, 'Tran Dan', '48 Le Loi', 'Da Nang', 'Viet Nam', 'abc@abc.abc', null),
(3, 'Quang Chinh', '437 Le Duan', 'Hai Phong', 'Viet Nam', 'abc@abc.abc', null),
(4, 'Tran Hau', '56 Trung Nu Vuong', 'Bien Hoa', 'Viet Nam', 'abc@abc.abc', null),
(5, 'Anh Quan', '123 Quang Trung', 'Ho Chi Minh', 'Viet Nam', 'abc@abc.abc', null);

insert into book_category
values (1, 'Giao duc'),
(2, 'Khoa hoc'),
(3, 'Giai tri'),
(4, 'Van hoc'),
(5, 'Doi song');

insert into book
values(1, 'Kamasutra', 1, 5),
(2, 'Cosmos', 2, 4),
(3, 'Doraemon', 3, 3),
(4, 'Lam Di', 4, 2),
(5, 'Fashion', 5, 1);


insert into book_order
values(1, 5),
(2, 4),
(3, 3),
(4, 2),
(5, 1);

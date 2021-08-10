drop database if exists CaseStudy;

create database CaseStudy;

use CaseStudy;

create table `position`(
	position_id int primary key auto_increment,
    position_name varchar(45)
);

create table education(
	education_id int primary key auto_increment,
    education_level varchar(45)
);
    
create table division(
		division_id int primary key auto_increment,
        division_name varchar(45)
);

create table `user`(
	username varchar(255) primary key,
    password varchar(255)
);

create table `role`(
	role_id int primary key auto_increment,
    role_name varchar(255)
);

create table user_role(
	fk_role_id int,
    fk_username varchar(255),
    primary key (fk_role_id, fk_username)
);

create table employee(
	employee_id int primary key auto_increment,
    employee_firstname varchar(45),
    employee_lastname varchar(45),
    fk_position_id int,
    foreign key (fk_position_id) references `position` (position_id),
    fk_education_id int,
    foreign key (fk_education_id) references education (education_id),
    fk_division_id int,
    foreign key (fk_division_id) references division (division_id),
    employee_birthday date,
    employee_card varchar(9),
    employee_salary varchar(45),
    employee_phone varchar(45),
    employee_email varchar(45),
    employee_address varchar(255),
    fk_username varchar(255),
    foreign key (fk_username) references `user` (username)
);

create table customer_type(
	customer_type_id int primary key auto_increment,
    customer_type_name varchar(45)
);

create table customer(
	customer_id int primary key auto_increment,
    fk_customer_type_id int,
    foreign key (fk_customer_type_id) references customer_type (customer_type_id),
    customer_firstname varchar(45),
    customer_lastname varchar(45),
    customer_birthday date,
    customer_card varchar(9),
    customer_phone varchar(45),
    customer_email varchar(45),
    customer_address varchar(255),
    customer_gender bit (1)
);

create table rent_type(
	rent_type_id int primary key auto_increment,
    rent_type_name varchar(45),
    rent_type_fee int
);

create table service_type(
	service_type_id int primary key auto_increment,
    service_type_name varchar(45)
);

create table service(
	service_id int primary key auto_increment,
    service_name varchar(45),
    service_area int,
    floors int,
    max_people int,
    service_cost double,
    fk_rent_type_id int,
    foreign key (fk_rent_type_id) references rent_type (rent_type_id),
    fk_service_type_id int,
    foreign key (fk_service_type_id) references service_type (service_type_id),
    room_standard varchar(45),
    other_convenience varchar (255),
    pool_area double
);

create table contract(
	contract_id int primary key auto_increment,
    fk_employee_id int,
    foreign key (fk_employee_id) references employee (employee_id),
    fk_customer_id int,
    foreign key (fk_customer_id) references customer (customer_id) on delete cascade on update cascade,
    fk_service_id int,
    foreign key (fk_service_id) references service (service_id),
    start_date date,
    end_date date,
    deposit int,
    total int
);

create table attach_service(
	attach_service_id int primary key auto_increment,
    attach_service_name varchar(45),
    attach_service_cost double,
    attach_service_unit int,
    attach_service_status varchar(45)
);

create table contract_detail(
	contract_detail_id int primary key auto_increment,
    fk_contract_id int,
    foreign key (fk_contract_id) references contract (contract_id) on delete cascade on update cascade,
    fk_attach_service_id int,
    foreign key (fk_attach_service_id) references attach_service (attach_service_id),
    quantity int
);

insert into `position`(position_name)
values ('Le tan'),
 ('Phuc vu'),
 ('Chuyen vien'),
 ('Giam sat'),
 ('Quan ly'),
 ('Giam Doc');
 
 insert into education(education_level)
 values ('Trung cap'),
 ('Cao dang'),
 ('Dai hoc'),
 ('Sau Dai hoc');

insert into division(division_name)
values ('Marketing'),
('Hanh chinh'),
('Quan ly'),
('Phuc Vu');

insert into `user`
 values('khoa1', 'khoadvd48'),
 ('khoa2', 'khoadvd48'),
 ('khoa3', 'khoadvd48'),
 ('thinh1', 'khoadvd48'),
 ('thu1', 'khoadvd48'),
('huong1', 'khoadvd48'),
('ha1', 'khoadvd48'),
('hoa1', 'khoadvd48'),
('hoa2', 'khoadvd48');

insert into employee(employee_firstname, employee_lastname, fk_position_id, fk_education_id, fk_division_id, employee_birthday,
employee_card, employee_salary, employee_phone, employee_email, employee_address, fk_username)
values ('Do Viet', 'Khoa', 2, 3, 2,'1998-09-06', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam', 'khoa1'),
 ('Do Viet Dang', 'Khoa', 1, 3, 3,'1997-12-06', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Quang Tri, Viet Nam', 'khoa2'),
 ('Do Van', 'Khoa', 1, 3, 1,'1996-04-21', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Quang Tri, Da Nang, Viet Nam', 'khoa3'),
 ('Dang Phuc', 'Thinh', 1, 3, 4,'1998-09-10', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam', 'thinh1'),
 ('Nguyen Tran Van', 'Thu', 1, 3, 4,'1998-01-01', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam','thu1'),
 ('Nguyen Thi', 'Huong', 1, 3, 3,'1995-02-26', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam', 'huong1'),
 ('Tran Thi', 'Ha', 2, 3, 2,'1997-11-07', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam', 'ha1'),
 ('Nguyen Do Tran Thi', 'Hoa', 3, 3, 1,'1993-12-31', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam', 'hoa1'),
 ('Nguyen', 'Hoa', 3, 3, 1,'1993-12-31', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam', 'hoa2');
 
 
 insert into service_type(service_type_name)
 values('Villa'),
 ('House'),
 ('Room');
 
 insert into rent_type(rent_type_name, rent_type_fee)
 values('Theo ngay', 1000000),
 ('Theo tuan', 2000000),
 ('Theo thang', 3000000);
 
 insert into customer_type(customer_type_name)
 values('Diamond'),
 ('Platinum'),
 ('Gold'),
 ('Silver'),
 ('Member');
 
 insert into customer(fk_customer_type_id, customer_firstname, customer_lastname, customer_birthday, customer_card, customer_phone,
 customer_email, customer_address, customer_gender)
 values(5, 'Do Viet Dang', 'Khoa', '1960-01-01', '100200300', '0123456789', 'abc@abc.com', 'Da Nang', 1),
 (4, 'Tran', 'Dan', '1970-01-01', '100200300', '0123456789', 'abc@abc.com', 'Ho Chi Minh', 1),
 (3, 'Nguyen Van', 'A', '1969-01-01', '100200300', '0123456789', 'abc@abc.com', 'Vung Tau', 1),
 (2, 'Dak Buh', 'Lmao', '1940-01-01', '100200300', '0123456789', 'abc@abc.com', 'Quang Tri', 0),
 (1, 'Adu', 'Vjp', '2010-01-01', '100200300', '0123456789', 'abc@abc.com', 'Da Nang', 1),
 (3, 'Dak Wa', 'Buh', '1930-01-01', '100200300', '0123456789', 'abc@abc.com', 'Da Nang', 0),
 (4, 'A Van', 'Nguyen', '1975-01-01', '100200300', '0123456789', 'abc@abc.com', 'Da Nang', 1),
 (1, 'Adu Dak', 'Wa', '1955-01-01', '100200300', '0123456789', 'abc@abc.com', 'Quang Tri', 0),
 (2, 'Do', 'Khoa', '1998-01-01', '100200300', '0123456789', 'abc@abc.com', 'Ha Noi', 1),
 (5, 'Duc', 'Cong', '2004-01-01', '100200300', '0123456789', 'abc@abc.com', 'Ha Long', 1),
 (2, 'Micheal', 'Jackson', '1964-01-01', '100200300', '0123456789', 'abc@abc.com', 'Binh Duong', 1),
 (3, 'Bruce', 'Lee', '1925-01-01', '100200300', '0123456789', 'abc@abc.com', 'Quang Tri', 1),
 (4, 'Ching', 'Chong', '1991-01-01', '100200300', '0123456789', 'abc@abc.com', 'Da Nang', 0),
 (1, 'Adolf', 'Hitler', '1960-01-01', '100200300', '0123456789', 'abc@abc.com', 'Hai Phong', 1),
(1, 'Adolf', 'Hitler', '1970-01-01', '100200300', '0123456789', 'abc@abc.com', 'Da Nang', 1),
(1, 'Adu Dak', 'Wa', '1950-01-01', '100200300', '0123456789', 'abc@abc.com', 'Quang tri', 0),
(1, 'Tran', 'Dan', '2010-01-01', '100200300', '0123456789', 'abc@abc.com', 'Ho Chi Minh', 1);

 -- insert into service
--  values(1, 'Villa 1', 100, 2, 5, 1000000, 1, 1, 'Dang dung'),
--  (2, 'Villa 2', 100, 2, 5, 1000000, 2, 1, 'Dang dung'),
--  (3, 'Villa 3', 100, 2, 5, 1000000, 3, 1, 'Dang dung'),
--  (4, 'House 1', 100, 2, 5, 1000000, 3, 2, 'Dang dung'),
--  (5, 'House 2', 100, 2, 5, 1000000, 2, 2, 'Dang dung'),
--  (6, 'House 3', 100, 2, 5, 1000000, 1, 2, 'Dang dung'),
--  (7, 'Room 1', 100, 2, 5, 1000000, 3, 3, 'Dang dung'),
--  (8, 'Room 2', 100, 2, 5, 1000000, 2, 3, 'Dang dung'),
--  (9, 'Room 3', 100, 2, 5, 1000000, 1, 3, 'Dang dung'),
--  (10, 'Villa 4', 100, 2, 5, 1000000, 1, 1, 'Dang dung');
 
 insert into service(service_name, service_area, service_cost, max_people, fk_rent_type_id, room_standard,
 other_convenience, pool_area, floors)
 values('Villa 1', 100, 1000000, 5, 1, '5 sao', 'dieu hoa, may suoi', 30, 2),
 ('Villa 2', 100, 1000000, 5, 2, '5 sao', 'dieu hoa, may suoi', 30, 1),
 ('Villa 3', 100, 1000000, 5, 3, '5 sao', 'dieu hoa, may suoi', 30, 3);
 
 insert into service(service_name, service_area, service_cost, max_people, fk_rent_type_id, room_standard,
 other_convenience, floors)
 values('House 1', 100, 1000000, 5, 1, '5 sao', 'dieu hoa, may suoi', 2),
 ('House 2', 100, 1000000, 5, 2, '5 sao', 'dieu hoa, may suoi', 1),
 ('House 3', 100, 1000000, 5, 3, '5 sao', 'dieu hoa, may suoi', 3);
 
 insert into service(service_name, service_area, service_cost, max_people, fk_rent_type_id)
 values('Room 1', 100, 1000000, 5, 1),
 ('Room 2', 100, 1000000, 5, 2),
 ('Room 3', 100, 1000000, 5, 3);
 
 insert into contract(fk_employee_id, fk_customer_id, fk_service_id, start_date, end_date, deposit, total)
 values(1, 5, 9, '2018-06-01', '2018-07-10', 500000, 12000000),
 (1, 5, 8, '2019-11-01', '2019-11-10', 500000, 2000000),
 (1, 5, 7, '2017-01-01', '2017-01-10', 500000, 2000000),
 (1, 5, 6, '2019-01-01', '2019-01-10', 500000, 2000000),
 (2, 5, 5, '2018-01-01', '2018-01-10', 500000, 2000000),
 (2, 8, 4, '2016-01-01', '2016-01-10', 500000, 2000000),
 (3, 8, 3, '2015-01-01', '2015-01-10', 500000, 2000000),
 (3, 8, 2, '2018-01-01', '2018-01-10', 500000, 2000000),
 (8, 14, 1, '2019-05-01', '2019-05-10', 500000, 2000000),
 (8, 14, 1, '2020-01-01', '2020-01-10', 500000, 1000000),
 (8, 14, 2, '2021-01-01', '2021-01-10', 500000, 2000000),
 (6, 14, 3, '2018-01-01', '2018-01-10', 500000, 2000000),
 (5, 6, 4, '2017-01-01', '2017-01-10', 500000, 2000000),
 (4, 7, 5, '2018-01-01', '2018-01-10', 500000, 2000000),
 (3, 9, 6, '2018-01-01', '2018-01-10', 500000, 2000000),
 (2, 11, 7, '2016-01-01', '2016-01-10', 500000, 22000000),
 (7, 2, 8, '2019-01-01', '2019-01-10', 500000, 2000000),
 (8, 3, 9, '2020-01-01', '2020-01-10', 500000, 2000000),
 (6, 4, 9, '2019-12-01', '2019-12-10', 500000, 12000000),
 (3, 8, 9, '2018-01-01', '2018-01-10', 500000, 2000000),
 (2, 1, 7, '2018-01-01', '2018-01-10', 500000, 2000000),
 (6, 3, 6, '2018-01-01', '2018-01-10', 500000, 2000000);
 
 insert into attach_service(attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
 values('Karaoke', 40000, 1, 'Con trong'),
 ('Massage', 50000, 1, 'Con trong'),
 ('Thuc an', 20000, 1, 'Con trong'),
 ('Thuc uong', 20000, 1, 'Con trong'),
 ('Thue xe', 70000, 1, 'Con trong');
 
 insert into contract_detail(fk_contract_id, fk_attach_service_id, quantity)
 values(18, 5, 8),
 (17, 4, 4),
 (16, 3, 5),
 (15, 2, 7),
 (14, 1, 2),
 (13, 1, 3),
 (12, 2, 4),
 (11, 4, 5),
 (10, 3, 6),
 (9, 2, 1),
 (8, 3, 2),
 (7, 5, 3),
 (6, 2, 4),
 (5, 4, 6),
 (4, 3, 7),
 (3, 2, 5),
 (2, 1, 1),
 (1, 3, 5),
 (18, 5, 8),
 (17, 4, 4),
 (16, 3, 5),
 (15, 2, 7),
 (14, 1, 2),
 (13, 1, 3),
 (12, 2, 4),
 (11, 4, 5),
 (10, 3, 6),
 (9, 2, 1),
 (8, 3, 2),
 (12, 5, 3),
 (6, 2, 4),
 (5, 4, 6),
 (4, 3, 7),
 (13, 2, 5),
 (2, 1, 1),
 (1, 3, 5),
 (2, 5, 5),
 (9, 4, 5),
 (1, 2, 5),
 (8, 1, 5),
 (1, 1, 5),
 (6, 2, 5),
 (3, 3, 5);
 
 
 select customer_id, customer_firstname, customer_lastname, customer_birthday, customer_card, customer_phone,
 customer_email, customer_address, customer_gender, customer_type_name from customer c 
 inner join customer_type ct
 on c.fk_customer_type_id = ct.customer_type_id
 order by c.customer_id;
 
 -- select customer_id, customer_firstname, customer_lastname, customer_birthday, customer_card, customer_phone,
--  customer_email, customer_address, customer_gender, customer_type_name from customer c 
--  inner join customer_type ct
--  on c.fk_customer_type_id = ct.customer_type_id
--  where c.customer_id =

-- delete from customer where customer_id = 7;

-- UPDATE customer
-- SET fk_customer_type_id, customer_firstname, customer_lastname, customer_birthday, customer_card, customer_phone,
--  customer_email, customer_address, customer_gender
-- WHERE customer_id = some_value ;

select employee_id, employee_firstname, employee_lastname, position_name, education_level, division_name, employee_birthday,
employee_card, employee_salary, employee_phone, employee_email, employee_address from employee e
inner join position p on e.fk_position_id = p.position_id
inner join education ed on e.fk_education_id = ed.education_id
inner join division dv on e.fk_division_id = dv.division_id;



-- insert into employee(employee_id, employee_firstname, employee_lastname, position_name, education_level, division_name, employee_birthday,
-- employee_card, employee_salary, employee_phone, employee_email, employee_address)
-- values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

select * from customer where customer_lastname like '%khoa%';
 
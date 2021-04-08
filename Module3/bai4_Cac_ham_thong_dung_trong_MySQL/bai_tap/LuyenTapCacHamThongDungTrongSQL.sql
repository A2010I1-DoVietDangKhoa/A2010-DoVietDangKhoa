drop database if exists luyentapham;

create database luyentapham;

use luyentapham;

create table sinhvien(
	id int,
    ten varchar(50),
    tuoi int(2),
    khoahoc varchar(4),
    sotien int
);

insert into sinhvien
values(1,'Hoang',21,'CNTT', 400000),
(2,'Viet',19,'DTVT', 320000),
(3,'Thanh',18,'KTDN', 400000),
(4,'Nhan',19,'CK', 450000),
(5,'Huong',20,'TCNH', 500000),
(5,'Huong',20,'TCNH', 200000);

select * from sinhvien
where ten = 'Huong';

select *, sum(sotien) 'tong tien'
from sinhvien
where ten in(
	select ten from sinhvien
    where ten = 'Huong'
);

select * from sinhvien
group by ten;
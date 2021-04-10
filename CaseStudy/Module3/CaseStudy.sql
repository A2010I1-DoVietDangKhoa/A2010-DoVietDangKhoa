drop database if exists CaseStudy;

create database CaseStudy;

use CaseStudy;

create table vitri(
	idvitri int primary key,
    tenvitri varchar(45)
);

create table trinhdo(
	idtrinhdo int primary key,
    trinhdo varchar(45)
);
    
    create table bophan(
		idbophan int primary key,
        tenbophan varchar(45)
);

create table nhanvien(
	idnhanvien int primary key,
    honhanvien varchar(45),
    tennhanvien varchar(45),
    fk_idvitri int,
    foreign key (fk_idvitri) references vitri (idvitri),
    fk_idtrinhdo int,
    foreign key (fk_idtrinhdo) references trinhdo (idtrinhdo),
    fk_idbophan int,
    foreign key (fk_idbophan) references bophan (idbophan),
    ngaysinh date,
    socmnd varchar(9),
    luong varchar(45),
    sdt varchar(45),
    email varchar(45),
    diachi varchar(255)
);

create table loaikhach(
	idloaikhach int primary key,
    tenloaikhach varchar(45)
);

create table khachhang(
	idkhachhang int primary key,
    fk_idloaikhach int,
    foreign key (fk_idloaikhach) references loaikhach (idloaikhach),
    hokhachhang varchar(45),
    tenkhachhang varchar(45),
    ngaysinh date,
    socmnd varchar(9),
    sdt varchar(45),
    email varchar(45),
    diachi varchar(255)
);

create table kieuthue(
	idkieuthue int primary key,
    tenkieuthue varchar(45),
    gia int
);

create table loaidichvu(
	idloaidichvu int primary key,
    tenloaidichvu varchar(45)
);

create table dichvu(
	iddichvu int primary key,
    tendichvu varchar(45),
    dientich int,
    sotang int,
    songuoitoida int,
    chiphithue int,
    fk_idkieuthue int,
    foreign key (fk_idkieuthue) references kieuthue (idkieuthue),
    fk_idloaidichvu int,
    foreign key (fk_idloaidichvu) references loaidichvu (idloaidichvu),
    trangthai varchar(45)
);

create table hopdong(
	idhopdong int primary key,
    fk_idnhanvien int,
    foreign key (fk_idnhanvien) references nhanvien (idnhanvien),
    fk_idkhachhang int,
    foreign key (fk_idkhachhang) references khachhang (idkhachhang),
    fk_iddichvu int,
    foreign key (fk_iddichvu) references dichvu (iddichvu),
    ngaylamhopdong date,
    ngayketthuc date,
    tiendatcoc int,
    tongtien int
);

create table dichvudikem(
	iddichvudikem int primary key,
    tendichvudikem varchar(45),
    gia int,
    donvi int,
    trangthai varchar(45)
);

create table hopdongchitiet(
	idhopdongchitiet int primary key,
    fk_idhopdong int,
    foreign key (fk_idhopdong) references hopdong (idhopdong),
    fk_iddichvudikem int,
    foreign key (fk_iddichvudikem) references dichvudikem (iddichvudikem),
    soluong int
);

insert into vitri
values (1, 'Le tan'),
 (2, 'Phuc vu'),
 (3, 'Chuyen vien'),
 (4, 'Giam sat'),
 (5, 'Quan ly'),
 (6, 'Giam Doc');
 
 insert into trinhdo
 values (1, 'Trung cap'),
 (2, 'Cao dang'),
 (3, 'Dai hoc'),
 (4, 'Sau Dai hoc');

insert into bophan
values (1, 'Marketing'),
(2, 'Hanh chinh'),
(3, 'Quan ly'),
(4, 'Phuc Vu');

insert into nhanvien
values (1, 'Do Viet', 'Khoa', 2, 3, 2,'1998-09-06', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam'),
 (2, 'Do Viet Dang', 'Khoa', 1, 3, 3,'1997-12-06', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Quang Tri, Viet Nam'),
 (3, 'Do Van', 'Khoa', 1, 3, 1,'1996-04-21', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Quang Tri, Da Nang, Viet Nam'),
 (4, 'Dang Phuc', 'Thinh', 1, 3, 4,'1998-09-10', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam'),
 (5, 'Nguyen Tran Van', 'Thu', 1, 3, 4,'1998-01-01', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam'),
 (6, 'Nguyen Thi', 'Huong', 1, 3, 3,'1995-02-26', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam'),
 (7, 'Tran Thi', 'Ha', 2, 3, 2,'1997-11-07', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam'),
 (8, 'Nguyen Do Tran Thi', 'Hoa', 3, 3, 1,'1993-12-31', '123456789', 90000000, '0794558312', 'abc@gmail.com',
 'Hai Chau, Da Nang, Viet Nam');
 
 insert into loaidichvu
 values(1, 'Villa'),
 (2, 'House'),
 (3, 'Room');
 
 insert into kieuthue
 values(1, 'Theo ngay', 1000000),
 (2, 'Theo tuan', 2000000),
 (3, 'Theo thang', 3000000);
 
 insert into loaikhach
 values(1, 'Diamond'),
 (2, 'Platinum'),
 (3, 'Gold'),
 (4, 'Silver'),
 (5, 'Member');
 
 insert into khachhang
 values(1, 5, 'Do Viet Dang', 'Khoa', '1960-01-01', '100200300', '0123456789', 'abc@abc.com', 'Da Nang'),
 (2, 4, 'Tran', 'Dan', '1970-01-01', '100200300', '0123456789', 'abc@abc.com', 'Ho Chi Minh'),
 (3, 3, 'Nguyen Van', 'A', '1969-01-01', '100200300', '0123456789', 'abc@abc.com', 'Vung Tau'),
 (4, 2, 'Dak Buh', 'Lmao', '1940-01-01', '100200300', '0123456789', 'abc@abc.com', 'Quang Tri'),
 (5, 1, 'Adu', 'Vjp', '2010-01-01', '100200300', '0123456789', 'abc@abc.com', 'Da Nang'),
 (6, 3, 'Dak Wa', 'Buh', '1930-01-01', '100200300', '0123456789', 'abc@abc.com', 'Da Nang'),
 (7, 4, 'A Van', 'Nguyen', '1975-01-01', '100200300', '0123456789', 'abc@abc.com', 'Da Nang'),
 (8, 1, 'Adu Dak', 'Wa', '1955-01-01', '100200300', '0123456789', 'abc@abc.com', 'Quang Tri'),
 (9, 2, 'Do', 'Khoa', '1998-01-01', '100200300', '0123456789', 'abc@abc.com', 'Ha Noi'),
 (10, 5, 'Duc', 'Cong', '2004-01-01', '100200300', '0123456789', 'abc@abc.com', 'Ha Long'),
 (11, 2, 'Micheal', 'Jackson', '1964-01-01', '100200300', '0123456789', 'abc@abc.com', 'Binh Duong'),
 (12, 3, 'Bruce', 'Lee', '1925-01-01', '100200300', '0123456789', 'abc@abc.com', 'Quang Tri'),
 (13, 4, 'Ching', 'Chong', '1991-01-01', '100200300', '0123456789', 'abc@abc.com', 'Da Nang'),
 (14, 1, 'Adolf', 'Hitler', '1960-01-01', '100200300', '0123456789', 'abc@abc.com', 'Hai Phong'),
(15, 1, 'Adolf', 'Hitler', '1970-01-01', '100200300', '0123456789', 'abc@abc.com', 'Da Nang'),
(16, 1, 'Adu Dak', 'Wa', '1950-01-01', '100200300', '0123456789', 'abc@abc.com', 'Quang tri'),
(17, 1, 'Tran', 'Dan', '2010-01-01', '100200300', '0123456789', 'abc@abc.com', 'Ho Chi Minh');
 insert into dichvu
 values(1, 'Villa 1', 100, 2, 5, 1000000, 1, 1, 'Dang dung'),
 (2, 'Villa 2', 100, 2, 5, 1000000, 2, 1, 'Dang dung'),
 (3, 'Villa 3', 100, 2, 5, 1000000, 3, 1, 'Dang dung'),
 (4, 'House 1', 100, 2, 5, 1000000, 3, 2, 'Dang dung'),
 (5, 'House 2', 100, 2, 5, 1000000, 2, 2, 'Dang dung'),
 (6, 'House 3', 100, 2, 5, 1000000, 1, 2, 'Dang dung'),
 (7, 'Room 1', 100, 2, 5, 1000000, 3, 3, 'Dang dung'),
 (8, 'Room 2', 100, 2, 5, 1000000, 2, 3, 'Dang dung'),
 (9, 'Room 3', 100, 2, 5, 1000000, 1, 3, 'Dang dung'),
 (10, 'Villa 4', 100, 2, 5, 1000000, 1, 1, 'Dang dung');
 insert into hopdong
 values(1, 1, 5, 9, '2018-06-01', '2018-07-10', 500000, 2000000),
 (2, 1, 5, 8, '2019-11-01', '2019-11-10', 500000, 2000000),
 (3, 1, 5, 7, '2017-01-01', '2017-01-10', 500000, 2000000),
 (4, 1, 5, 6, '2019-01-01', '2019-01-10', 500000, 2000000),
 (5, 2, 5, 5, '2018-01-01', '2018-01-10', 500000, 2000000),
 (6, 2, 8, 4, '2016-01-01', '2016-01-10', 500000, 2000000),
 (7, 3, 8, 3, '2015-01-01', '2015-01-10', 500000, 2000000),
 (8, 3, 8, 2, '2018-01-01', '2018-01-10', 500000, 2000000),
 (9, 8, 14, 1, '2019-05-01', '2019-05-10', 500000, 2000000),
 (10, 8, 14, 1, '2020-01-01', '2020-01-10', 500000, 2000000),
 (11, 8, 14, 2, '2021-01-01', '2021-01-10', 500000, 2000000),
 (12, 6, 14, 3, '2018-01-01', '2018-01-10', 500000, 2000000),
 (13, 5, 6, 4, '2017-01-01', '2017-01-10', 500000, 2000000),
 (14, 4, 7, 5, '2018-01-01', '2018-01-10', 500000, 2000000),
 (15, 3, 9, 6, '2018-01-01', '2018-01-10', 500000, 2000000),
 (16, 2, 11, 7, '2016-01-01', '2016-01-10', 500000, 2000000),
 (17, 7, 2, 8, '2019-01-01', '2019-01-10', 500000, 2000000),
 (18, 8, 3, 9, '2020-01-01', '2020-01-10', 500000, 2000000),
 (19, 6, 4, 9, '2019-12-01', '2019-12-10', 500000, 2000000),
 (20, 3, 8, 9, '2018-01-01', '2018-01-10', 500000, 2000000),
 (21, 2, 1, 10, '2018-01-01', '2018-01-10', 500000, 2000000),
 (22, 6, 3, 10, '2018-01-01', '2018-01-10', 500000, 2000000);
 insert into dichvudikem
 values(1, 'Karaoke', 40000, 1, 'Con trong'),
 (2, 'Massage', 50000, 1, 'Con trong'),
 (3, 'Thuc an', 20000, 1, 'Con trong'),
 (4, 'Thuc uong', 20000, 1, 'Con trong'),
 (5, 'Thue xe', 70000, 1, 'Con trong');
 
 insert into hopdongchitiet
 values(1, 18, 5, 8),
 (2, 17, 4, 4),
 (3, 16, 3, 5),
 (4, 15, 2, 7),
 (5, 14, 1, 2),
 (6, 13, 1, 3),
 (7, 12, 2, 4),
 (8, 11, 4, 5),
 (9, 10, 3, 6),
 (10, 9, 2, 1),
 (11, 8, 3, 2),
 (12, 7, 5, 3),
 (13, 6, 2, 4),
 (14, 5, 4, 6),
 (15, 4, 3, 7),
 (16, 3, 2, 5),
 (17, 2, 1, 1),
 (18, 1, 3, 5),
 (19, 18, 5, 8),
 (20, 17, 4, 4),
 (21, 16, 3, 5),
 (22, 15, 2, 7),
 (23, 14, 1, 2),
 (24, 13, 1, 3),
 (25, 12, 2, 4),
 (26, 11, 4, 5),
 (27, 10, 3, 6),
 (28, 9, 2, 1),
 (29, 8, 3, 2),
 (30, 12, 5, 3),
 (31, 6, 2, 4),
 (32, 5, 4, 6),
 (33, 4, 3, 7),
 (34, 13, 2, 5),
 (35, 2, 1, 1),
 (36, 1, 3, 5),
 (37, 2, 5, 5),
 (38, 9, 4, 5),
 (39, 1, 2, 5),
 (40, 8, 1, 5),
 (41, 1, 1, 5),
 (42, 6, 2, 5),
 (43, 3, 3, 5);
 -- Cau 2
 
SELECT *
 from nhanvien
where (tennhanvien like 'H%')
 or (tennhanvien like 'K%')
 or (tennhanvien like '%T')
 AND char_length(honhanvien) + char_length(tennhanvien) <= 15;
 
 -- Cau 3
 
 SELECT *
 FROM khachhang
 where (diachi like '%Da Nang%' or diachi like '%Quang Tri%')
 and (year(current_time()) - year(ngaysinh) >=18 and year(current_time()) - year(ngaysinh) <=50);
 
 -- Cau 4
 
 select idhopdong, hokhachhang, tenkhachhang, count(fk_idkhachhang) solandat from hopdong h
 inner join khachhang k
 on h.fk_idkhachhang = k.idkhachhang
 where fk_idloaikhach = 1
 group by k.tenkhachhang
 order by solandat;
 
 -- Cau 5
 
select idkhachhang, hokhachhang, tenkhachhang,
 idhopdong, d.tendichvu, ngaylamhopdong, ngayketthuc, (d.chiphithue + soluong * gia) as 'tongtien' from khachhang k
 left join hopdong h
 on k.idkhachhang = h.fk_idkhachhang
 left join dichvu d
 on h.fk_iddichvu = d.iddichvu
 left join hopdongchitiet hdct
 on h.idhopdong = hdct.fk_idhopdong
 left join dichvudikem dvdk
 on hdct.fk_iddichvudikem = dvdk.iddichvudikem
 left join dichvu dv
 on h.fk_iddichvu = dv.iddichvu
 order by idkhachhang;
 
-- Cau 6

select iddichvu, tendichvu, dientich, chiphithue, tenloaidichvu from dichvu dv
inner join loaidichvu ldv
on dv.fk_idloaidichvu = ldv.idloaidichvu
inner join hopdong hd
on dv.iddichvu = hd.fk_iddichvu
where (month(hd.ngaylamhopdong) != 1 or month(hd.ngaylamhopdong) != 2 or month(hd.ngaylamhopdong) != 3)
and year(hd.ngaylamhopdong) = 2019
order by dv.iddichvu;

-- Cau 7

select iddichvu, tendichvu, dientich, chiphithue, tenloaidichvu
from dichvu dv
inner join loaidichvu ldv
on dv.fk_idloaidichvu = ldv.idloaidichvu
inner join hopdong hd
on dv.iddichvu = hd.fk_iddichvu
where year(hd.ngaylamhopdong) = 2018 and year(hd.ngaylamhopdong) != 2019
group by iddichvu
-- having nam1 > 0 and nam2 = 0
order by dv.iddichvu;

-- Cau 8

select distinct hokhachhang, tenkhachhang from khachhang;

select hokhachhang, tenkhachhang from khachhang
group by hokhachhang, tenkhachhang;

select hokhachhang, tenkhachhang from khachhang
union
select hokhachhang, tenkhachhang from khachhang;

-- Cau 9

select *, count(fk_idkhachhang) as 'solandat' from hopdong
where year(ngaylamhopdong) = 2019
group by month(ngaylamhopdong)
order by month(ngaylamhopdong);

-- Cau 10

select idhopdong, ngaylamhopdong, ngayketthuc, tiendatcoc, count(idhopdongchitiet) as 'soluongdichvu' from hopdong hd
left join hopdongchitiet hdct
on hd.idhopdong = hdct.fk_idhopdong
group by idhopdong
order by idhopdong;

-- Cau 11

select * from khachhang kh
left join hopdong hd
on kh.idkhachhang = hd.fk_idkhachhang
left join hopdongchitiet hdct
on hd.idhopdong = hdct.fk_idhopdong
left join dichvudikem dvdk
on hdct.fk_iddichvudikem = dvdk.iddichvudikem
where (diachi like '%Da Nang%' or diachi like '%Vung%') and fk_idloaikhach = 1;

-- Cau 12

select idhopdong, tennhanvien, tenkhachhang, k.sdt, tendichvu, tiendatcoc, count(idhopdongchitiet) as soluongdichvudikem from khachhang k
left join hopdong hd
on k.idkhachhang = hd.fk_idkhachhang
left join dichvu dv
on hd.fk_iddichvu = dv.iddichvu
left join hopdongchitiet hdct
on hdct.fk_idhopdong = hd.idhopdong
left join nhanvien nv
on hd.fk_idnhanvien = nv.idnhanvien
where (month(hd.ngaylamhopdong) = 10 or month(hd.ngaylamhopdong) = 11 or month(hd.ngaylamhopdong) = 12) and year(hd.ngaylamhopdong) = 2019
group by idhopdong;

-- Cau 13 block

select *, count(fk_iddichvudikem) as sudungnhieunhat from dichvudikem dvdk
inner join hopdongchitiet hdct
on dvdk.iddichvudikem = hdct.fk_iddichvudikem
group by iddichvudikem
order by sudungnhieunhat desc;

-- Cau 14

select idhopdong, tenloaidichvu, tendichvudikem, count(iddichvudikem) as solansudung from hopdong hd
inner join hopdongchitiet hdct
on hd.idhopdong = hdct.fk_idhopdong
inner join dichvudikem dvdk
on hdct.fk_iddichvudikem = dvdk.iddichvudikem
inner join dichvu dv
on hd.fk_iddichvu = dv.iddichvu
inner join loaidichvu ldv
on dv.fk_idloaidichvu = ldv.idloaidichvu
group by idhopdong
having solansudung = 1;

-- Cau 15

select IDNhanVien, honhanvien, tennhanvien, TrinhDo, TenBoPhan, sdt, DiaChi, count(fk_idnhanvien) as solanlaphopdong from nhanvien nv
inner join hopdong hd
on nv.idnhanvien = hd.fk_idnhanvien
inner join trinhdo td
on nv.fk_idtrinhdo = td.idtrinhdo
inner join bophan bp
on bp.idbophan = nv.fk_idbophan
where year(hd.ngaylamhopdong) = 2018 or year(hd.ngaylamhopdong) = 2019
group by idnhanvien
having solanlaphopdong <= 3;
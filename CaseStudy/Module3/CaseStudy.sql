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
values (1, 'Nhan Vien'),
 (2, 'Quan Ly'),
 (3, 'Giam Doc');
 
 insert into trinhdo
 values (1, 'Cap 3'),
 (2, 'Cao Dang'),
 (3, 'Dai Hoc');

insert into bophan
values (1, 'Nhan Su'),
(2, 'Quan Tri'),
(3, 'Tiep Tan'),
(4, 'Phuc Vu');

alter table khachhang
add column solandatphong int;

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
 
 insert into loaikhach
 values (1, 'None'),
 (2, 'Bronze'),
 (3, 'Silver'),
 (4, 'Gold'),
 (5, 'Diamond');
 
 
 insert into khachhang
 values (1, 1, 'Tran', 'Dan', '1970-01-15', '113114115', '01214634856', 'abc@abc.com', '123 Da Nang, Viet Nam', 4);
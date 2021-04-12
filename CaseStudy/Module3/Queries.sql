use casestudy;

-- Cau 2
 
SELECT *
 from nhanvien
where ((tennhanvien like 'H%')
 or (tennhanvien like 'K%')
 or (tennhanvien like 'T%'))
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

-- select iddichvu, tendichvu, dientich, chiphithue, tenloaidichvu
-- from dichvu dv
-- inner join loaidichvu ldv
-- on dv.fk_idloaidichvu = ldv.idloaidichvu
-- inner join hopdong hd
-- on dv.iddichvu = hd.fk_iddichvu
-- where year(hd.ngaylamhopdong) = 2018 and year(hd.ngaylamhopdong) != 2019
-- group by iddichvu
-- having nam1 > 0 and nam2 = 0
-- order by dv.iddichvu;

select iddichvu, tendichvu, dientich, chiphithue, tenloaidichvu
from dichvu dv
inner join loaidichvu ldv
on dv.fk_idloaidichvu = ldv.idloaidichvu
inner join hopdong hd
on dv.iddichvu = hd.fk_iddichvu
where dv.iddichvu in (
	select iddichvu from dichvu dv
    inner join loaidichvu ldv
	on dv.fk_idloaidichvu = ldv.idloaidichvu
	inner join hopdong hd
	on dv.iddichvu = hd.fk_iddichvu
    where year(hd.ngaylamhopdong) = 2018
)
and dv.iddichvu not in(
	select iddichvu from dichvu dv
    inner join loaidichvu ldv
	on dv.fk_idloaidichvu = ldv.idloaidichvu
	inner join hopdong hd
	on dv.iddichvu = hd.fk_iddichvu
    where year(hd.ngaylamhopdong) = 2019
)
group by dv.iddichvu;

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

-- Cau 13

select dvdk.*, count(fk_iddichvudikem) as sudung
from dichvudikem dvdk
	left join hopdongchitiet hdct
	on dvdk.iddichvudikem = hdct.fk_iddichvudikem
group by iddichvudikem
having sudung in (
	select tmp.sudung
    from (
	select count(fk_iddichvudikem) as sudung
	from dichvudikem dvdk
		left join hopdongchitiet hdct
		on dvdk.iddichvudikem = hdct.fk_iddichvudikem
	group by iddichvudikem
	order by sudung desc
    limit 1) as tmp
);


-- Cau 14

select idhopdong, tenloaidichvu, tendichvudikem, count(fk_iddichvudikem) as solansudung from hopdong hd
left join hopdongchitiet hdct
on hd.idhopdong = hdct.fk_idhopdong
left join dichvudikem dvdk
on hdct.fk_iddichvudikem = dvdk.iddichvudikem
left join dichvu dv
on hd.fk_iddichvu = dv.iddichvu
left join loaidichvu ldv
on dv.fk_idloaidichvu = ldv.idloaidichvu
group by idhopdong
having solansudung = 1;

select idhopdong, tenloaidichvu, tendichvudikem, count(fk_iddichvudikem) as solansudung from dichvudikem dvdk
left join hopdongchitiet hdct
on dvdk.iddichvudikem = hdct.fk_iddichvudikem
left join hopdong hd
on hd.idhopdong = hdct.fk_idhopdong
left join dichvu dv
on hd.fk_iddichvu = dv.iddichvu
left join loaidichvu ldv
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

-- Cau 16

delete from nhanvien
where idnhanvien not in(
select distinct * from(
select idnhanvien from nhanvien nv
inner join hopdong hd
on nv.idnhanvien = hd.fk_idnhanvien
where (year(ngaylamhopdong) = 2017 
	or year(ngaylamhopdong) = 2018 
	or year(ngaylamhopdong) = 2019)
    and idnhanvien is not null
) as whatever
);

-- Cau 17

update khachhang as kh
inner join (
select idkhachhang, tenkhachhang, fk_idloaikhach, sum(tongtien) as tongtien from khachhang kh
inner join hopdong hd
on kh.idkhachhang = hd.fk_idkhachhang
group by tenkhachhang
having tongtien >= 10000000 and fk_idloaikhach = 2) as B
on kh.idkhachhang = B.idkhachhang
set kh.fk_idloaikhach = 1;

-- Cau 18

delete khachhang, hopdong from khachhang inner join hopdong
where fk_idkhachhang = idkhachhang
and idkhachhang in(
select * from(
select idkhachhang from khachhang kh
inner join hopdong hd
on kh.idkhachhang = hd.fk_idkhachhang
where year(ngaylamhopdong) < 2016
    and idkhachhang is not null
) as whatever
);

-- Cau 19
update dichvudikem as dvdk inner join(
select *, count(fk_iddichvudikem) from dichvudikem dvdk
inner join hopdongchitiet hdct on dvdk.iddichvudikem = hdct.fk_iddichvudikem
group by iddichvudikem
having count(fk_iddichvudikem) >= 10) as whatever
on dvdk.iddichvudikem = whatever.iddichvudikem
set dvdk.gia = dvdk.gia * 2;

-- Cau 20

select idkhachhang, hokhachhang, tenkhachhang, email, sdt, ngaysinh, diachi from khachhang
union all
select idnhanvien, honhanvien, tennhanvien, email, sdt, ngaysinh, diachi from nhanvien;

-- Cau 21

create view v_nhanvien as 
select nv.* from nhanvien nv
where idnhanvien in(
	select nv.idnhanvien from nhanvien nv
    inner join hopdong hd
    on nv.idnhanvien = hd.fk_idnhanvien
    where year(hd.ngaylamhopdong) = 2019 and nv.diachi like '%Hai Chau%' and idnhanvien is not null
);

create view v_nhanvien as 
select distinct nv.* from nhanvien nv
inner join hopdong hd
on nv.idnhanvien = hd.fk_idnhanvien
where year(hd.ngaylamhopdong) = 2019 and nv.diachi like '%Hai Chau%';

-- drop view v_nhanvien;

select * from v_nhanvien;

-- Cau 22

update nhanvien
set nhanvien.diachi = 'Lien Chieu, Da Nang, Viet Nam'
where nhanvien.idnhanvien in (select idnhanvien from v_nhanvien);

-- Cau 23

DELIMITER //

CREATE PROCEDURE sp_1

(IN idkhachhang_in INT(11))

BEGIN

  delete from khachhang
  where idkhachhang = idkhachhang_in;

END //

DELIMITER ;

-- Cau 25

delimiter //
drop trigger if exists tr_1 //
create trigger tr_1
after delete on hopdong for each row
begin
	set @x = (select count(idhopdong) as count from hopdong);
end;
// delimiter ;
set @x = 0;
delete from hopdong where hopdong.idhopdong = 4;
select @x as 'Total after delete';
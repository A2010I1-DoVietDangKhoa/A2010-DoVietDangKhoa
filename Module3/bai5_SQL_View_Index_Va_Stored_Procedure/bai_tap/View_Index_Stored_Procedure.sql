drop database if exists demo;

create database demo;

use demo;

create table products(
	id int(10) not null primary key,
	productCode varchar(10) not null,
	productName varchar(50) not null,
	productPrice int not null,
	productAmount int not null,
	productDescription varchar(100),
	productStatus varchar(50)
);

CREATE UNIQUE INDEX productCodeIndex
ON products(productCode);

create index priceAndNameIndex
on products(productPrice, productName);

create view products_view as 
select productCode, productName, productPrice, productStatus from products;

select * from products_view;
create or replace view products_view as
select productCode, productName, productPrice, productAmount, productStatus from products;

delimiter //

create procedure viewAllProducts()

begin
	select * from products;
end

// delimiter ;

delimiter //

create procedure addNewProduct(in id int(10),
	in productCode varchar(10),
	in productName varchar(50),
	in productPrice int,
	in productAmount int,
	in productDescription varchar(100),
	in productStatus varchar(50))

begin
	insert into products
    value(id,
	productCode,
	productName,
	productPrice,
	productAmount,
	productDescription,
	productStatus);
end

// delimiter ;


delimiter //

create procedure editProductDesc(in id int(10), in descript varchar(100))
begin
	update products
    set productDescription = descript
    where id = id;
end

// delimiter ;

delimiter //

create procedure deleteProductD(in id int(10))
begin
	delete from products
    where id = id;
end

// delimiter ;
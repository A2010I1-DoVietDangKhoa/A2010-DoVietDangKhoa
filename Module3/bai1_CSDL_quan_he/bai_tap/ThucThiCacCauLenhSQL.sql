use classicmodels;

SELECT * FROM customers;

SELECT customerName, phone, city, country FROM customers;

SELECT * FROM customers WHERE customerName = 'Atelier Graphique';

SELECT * FROM customers WHERE customername like '%A%';

SELECT * FROM customers WHERE city IN ('Nantes',' Las Vegas',' Warszawa','NYC');

insert into customers 
values (109,'Tran Dan','Tran','Dan','0123.456.789','193 Nguyen Luong Bang',null,'Da Nang',null,'55000','Vietnam',1370,150000.0);

insert into customers (customerNumber, customerName, contactFirstName ,contactLastName, phone, addressLine1, city, country)
values (111, 'Lmao', 'Buh', 'Dak', '00000000000', 'nope', 'nope', 'nope' );

select customerName
from customers
where customerNumber = 111;

update customers
set customerName = 'Dak Buh Lmao'
where customerName = 'Atelier Graphique';

alter table customers
add column customerEmail varchar(30);

select * from products;

create table carTest(
	carID int primary key auto_increment,
	carName varchar(30),
    carSpecs varchar(100)
);

insert into carTest
values(1,'Lamborghini', 'Fast af boi');

select * from carTest;
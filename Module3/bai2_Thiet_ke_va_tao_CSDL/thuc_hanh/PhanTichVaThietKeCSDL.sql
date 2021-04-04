drop database if exists VehiclesStore;

create database VehiclesStore;

use VehiclesStore;

create table offices (
  officeCode varchar(10) primary key not null,
  city varchar(50) not null,
  phone varchar(50) not null,
  addressLine1 varchar(50) not null,
  addressLine2 varchar(50) default null,
  state varchar(50) default null,
  country varchar(50) not null,
  postalCode varchar(15) not null
);


create table employees (
  employeeNumber int primary key not null,
  lastName varchar(50) not null,
  firstName varchar(50) not null,
  email varchar(100) not null,
  jobTitle varchar(50) not null,
  reportTo int not null,
  foreign key (reportTo) references employees (employeeNumber),
  fk_officeCode varchar(10) not null,
  foreign key (fk_officeCode) references offices (officeCode)
);

create table customers(
	customerNumber int not null primary key,
    customerName varchar(50) not null,
    contactLastName varchar(50) not null,
    contactFirstName varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50),
    city varchar(50) not null,
    state varchar(50) not null,
    postalCode varchar(15) not null,
    country varchar(50) not null,
    creditLimit float,
    salesRepEmployeeNumber int not null,
    foreign key (salesRepEmployeeNumber) references employees (employeeNumber)
);

create table orders(
	orderNumber int primary key not null,
    orderDate date not null,
    requiredDate date not null,
    shippedDate date not null,
    status varchar(15) not null,
    comments text default null,
    quantityOrdered int not null,
    priceEach float not null,
    fk_customerNumber int not null,
    foreign key (fk_customerNumber) references customers (customerNumber)
);

create table payments(
    checkNumber varchar(50) not null,
    paymentDate date not null,
    amount float not null,
    fk_customerNumber int not null,
    foreign key (fk_customerNumber) references customers (customerNumber)
);

create table products(
	productCode int primary key not null,
    productName varchar(70) not null,
    productScale varchar(10) not null,
    productVendor varchar(50) not null,
    productDescription text not null,
    quantityInStock int not null,
    buyPrice float not null,
    MSRP float not null,
    fk_productLine varchar(50) not null,
    foreign key (fk_productLine) references productlines (productLine)
);

create table productlines (
	productLine varchar(50) primary key not null,
    textDescription text not null,
    image text not null
);


create table orderdetails(
	fk_productCode int not null,
    fk_orderNumber int not null,
    foreign key (fk_productCode) references products (productCode),
    foreign key (fk_orderNumber) references orders (orderNumber)
);
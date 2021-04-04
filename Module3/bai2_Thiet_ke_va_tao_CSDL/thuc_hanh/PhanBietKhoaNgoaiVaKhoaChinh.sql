drop database if exists PhanBietKhoaNgoaiVaKhoaChinh;

create database PhanBietKhoaNgoaiVaKhoaChinh;

use PhanBietKhoaNgoaiVaKhoaChinh;

create table customers(
	customer_number int primary key,
    fullname varchar(30),
    address varchar(30),
    email varchar(30),
    phonenumber varchar(30)
);

create table accounts(
	account_number int primary key,
    account_type varchar(20),
    opendate date,
    balance int,
    fk_customer_number int,
    foreign key (fk_customer_number) references customers (customer_number)
);

create table transactions(
	tran_number int primary key,
    amounts int,
    descriptions varchar(50),
    tran_date date,
    fk_account_number int,
    foreign key (fk_account_number) references accounts (account_number)
);
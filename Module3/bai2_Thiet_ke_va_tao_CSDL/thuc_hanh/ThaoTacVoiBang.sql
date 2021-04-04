drop database if exists thao_tac_voi_bang;

create database thao_tac_voi_bang;

use thao_tac_voi_bang;

CREATE TABLE contacts
( contact_id INT NOT NULL AUTO_INCREMENT,
  last_name VARCHAR(30) NOT NULL,
  first_name VARCHAR(25),
  birthday DATE,
  CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

CREATE TABLE suppliers
( supplier_id INT NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

DROP TABLE contacts, suppliers;

ALTER TABLE contacts
  ADD address varchar(50) NOT NULL
    AFTER contact_id;
    
ALTER TABLE contacts
  MODIFY last_name varchar(50) NULL;
  
ALTER TABLE contacts
  DROP COLUMN address;
  
ALTER TABLE contacts
CHANGE COLUMN address contact_address
    varchar(20) NOT NULL;
    
ALTER TABLE contacts
  RENAME TO customers;
  
drop database thao_tac_voi_bang;
drop database if exists demo;
create database demo;

USE demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
insert into users(name, email, country) values('Khoa','khoa@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Chinh','chinh@codegym.vn','Viet Nam');

select * from users where `name` = 'khoa';

select * from users order by `name`;

select * from users;

DELIMITER //

CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.name, users.email, users.country

    FROM users

    where users.id = user_id;

    END //

DELIMITER ;

  

DELIMITER //

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);

    END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE get_all_user()

BEGIN

    SELECT *

	FROM users;

    END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE update_user_by_id(IN user_id int(11),
	IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50))

BEGIN

    UPDATE users

	set `name` = user_name, country = user_country, email = user_email
	
    WHERE id = user_id;
    END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE delete_user_by_id(IN user_id int(11),
	IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50))

BEGIN

    UPDATE users

	set `name` = user_name, country = user_country, email = user_email
	
    WHERE id = user_id;
    END //

DELIMITER ;

create table Permision(

id int(11) auto_increment primary key,

`name` varchar(50)

);

 

create table User_Permision(

permision_id int(11),

user_id int(11)

);


insert into Permision(`name`) values('add');

insert into Permision(`name`) values('edit');

insert into Permision(`name`) values('delete');

insert into Permision(`name`) values('view');

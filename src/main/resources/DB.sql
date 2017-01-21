create database smart4j;
use smart4j;
create table customer
(
id bigint(20) not null auto_increment primary key,
name varchar(255) default null,
contact varchar(255) default null,
telephone varchar(255) default null,
email varchar(255) default null,
remark text)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into customer values ('1','customer1','jack','13661566736','jack@gmail.com',null);
insert into customer values ('2','customer2','rose','13661566234','rose@gmail.com',null);

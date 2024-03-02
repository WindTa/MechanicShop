drop database if exists mechanic_shop;
create database mechanic_shop;
use mechanic_shop;

create table customer (
    customer_id int primary key auto_increment,
    customer_lid varchar(20) not null unique,
    `name` varchar(50) not null,
    age int not null,
    phone varchar(50) not null,
    email varchar(512) not null
);
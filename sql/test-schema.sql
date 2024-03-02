drop database if exists mechanic_shop_test;
create database mechanic_shop_test;
use mechanic_shop_test;

create table customer (
    customer_id int primary key auto_increment,
    customer_lid varchar(20) not null unique,
    `name` varchar(50) not null,
    age int not null,
    phone varchar(50) not null,
    email varchar(512) not null
);

delimiter //
create procedure set_known_good_state()
begin
    -- delete starts with children
    delete from customer;
    alter table customer auto_increment=1;

    -- insert start with parents
    insert into customer (customer_lid, `name`, age, phone, email) values
        ('Y111111', 'Customer1', 26, '111-111-1111', 'Customer1@gmail.com'),
        ('Y222222', 'Customer2', 45, '222-222-2222', 'Customer2@gmail.com');

end//
delimiter ;
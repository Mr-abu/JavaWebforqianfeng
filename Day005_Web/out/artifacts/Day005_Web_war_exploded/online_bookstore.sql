# 图书分类基本信息表
CREATE TABLE book_classification (
    id INT PRIMARY KEY ,
    class_name VARCHAR(40) NOT NULL
);

# 图书基本信息表
CREATE TABLE book(
    id int primary key,
    class_id int not null,
    original_name varchar(50),
    name varchar(50) not null,
    original_price int not null,
    price int not null,
    description varchar(700) not null,
    author varchar(60) not null,
    translator varchar(60),
    publishing_house varchar(60) not null,
    isbn int not null,
    image varchar(60) not null
);

#客户基本信息表
create table store_users (
    username varchar(20) primary key ,
    password varchar(20) not null ,
    name varchar(20) not null ,
    phone varchar(20) not null ,
    address varchar(120) not null,
    email varchar(60) null
);

#订单信息表
create table orders (
    id int primary key ,
    username varchar(20) not null ,
    order_time DATE not null

);
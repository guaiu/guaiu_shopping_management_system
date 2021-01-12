create database goodsDatabase
go
use goodsDatabase

create table GOODS
(
gid int not null unique identity,
gname varchar(32) unique not null,
gprice numeric(16,2) not null,
gnum numeric(16,0) not null,
primary key(gid)
)

create table MYUSER 
(
userid int not null unique identity,
username varchar(32) unique not null,
userpassword varchar(32) not null,
primary key(userid)
);

insert
into MYUSER
VALUES('admin','123');
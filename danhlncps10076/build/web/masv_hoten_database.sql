use master
go
drop database masv_hoten
go
create database masv_hoten
go
use masv_hoten
go
create table account
(
	username varchar(50) primary key,
	password varchar(50)
)
go
insert into accountvalues('admin','123')
go
select * from account
go
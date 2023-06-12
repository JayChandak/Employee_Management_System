create database employeemanagementsystem;
show databases;
use employeemanagementsystem;

create table login(username varchar(20), password varchar(20));
insert into login values('admin','12345678');

select * from login; 
drop table login;

create table employee(name varchar(20),fname varchar(20),dob varchar(30),salary varchar(20),address varchar(100),phoneno varchar(20),email varchar(20),education varchar(20),designation varchar(20),aadhar varchar(20),empId varchar(20));
select * from employee;

drop table employee;
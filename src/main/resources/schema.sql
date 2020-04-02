drop table USER if exists;

create table USER (Id serial, Name varchar(5), Dept varchar(50) NOT NULL, Salary bigint);
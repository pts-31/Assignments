CREATE DATABASE `sqltriggers`;

CREATE TABLE `employee` (
  `EmpId` int(11) DEFAULT NULL,
  `EmpName` varchar(20) DEFAULT NULL,
  `Dept` varchar(10) DEFAULT NULL,
  `Salary` int(11) DEFAULT NULL
) ;

CREATE TABLE `department` (
  `depId` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `noOfEmployees` int(11) DEFAULT NULL
) ;

CREATE TABLE `employeeaudit` (
  `EmpId` int(11) DEFAULT NULL,
  `EmpName` varchar(20) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  `Action` varchar(20) DEFAULT NULL
) ;

delimiter $$
create trigger Before_insert
before insert on employee
for each row
begin
insert into employeeaudit(EmpId,EmpName,Date,Action)
values(new.employee_id,new.employee_name,now(),'insert');
end $$
delimiter ;

delimiter $$
create trigger After_insert
after insert on employee
for each row
begin
insert into employeeaudit(EmpId,EmpName,Date,Action)
values(new.employee_id,new.employee_name,now(),'inserted');
end $$
delimiter ;

delimiter $$
create trigger Before_update
before update on employee
for each row
begin
insert into employeeaudit(EmpId,EmpName,Date,Action)
values(old.employee_id,old.employee_name,now(),'update');
end $$
delimiter ;

delimiter $$
create trigger After_update
after update on employee
for each row
begin
insert into employeeaudit(EmpId,EmpName,Date,Action)
values(new.employee_id,new.employee_name,now(),'updated');
end $$
delimiter ;

delimiter $$
create trigger Before_delete
before delete on employee
for each row
begin
insert into employeeaudit(EmpId,EmpName,Date,Action)
values(old.employee_id,old.employee_name,now(),'delete');
end $$
delimiter ;

delimiter $$
create trigger After_delete
after delete on employee
for each row
begin
insert into employeeaudit(EmpId,EmpName,Date,Action)
values(old.employee_id,old.employee_name,now(),'deleted');
end $$
delimiter ;


insert into employee values(1,"Piyusha","IT",20000);

SET SQL_SAFE_UPDATES = 0;

update employee set EmpName="Anusha" where EmpId=1;

select * from employeeaudit;

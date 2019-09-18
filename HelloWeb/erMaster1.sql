
/* Drop Indexes */

DROP INDEX DEPT_LOCATION_IX;
DROP INDEX EMP_DEPARTMENT_IX;
DROP INDEX EMP_JOB_IX;
DROP INDEX EMP_MANAGER_IX;
DROP INDEX EMP_NAME_IX;



/* Drop Views */

DROP VIEW HR.EMP_DETAILS_VIEW;



/* Drop Triggers */

DROP TRIGGER SECURE_EMPLOYEES;
DROP TRIGGER UPDATE_JOB_HISTORY;



/* Drop Tables */

DROP TABLE HR.EMPLOYEES CASCADE CONSTRAINTS;
DROP TABLE HR.DEPARTMENTS CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE HR.AUTONUM;
DROP SEQUENCE HR.DEPARTMENTS_SEQ;
DROP SEQUENCE HR.EMPLOYEES_SEQ;
DROP SEQUENCE HR.LOCATIONS_SEQ;




/* Create Sequences */

CREATE SEQUENCE HR.AUTONUM INCREMENT BY 1 MINVALUE 1 MAXVALUE 1000000 START WITH 7 CYCLE NOCACHE;
CREATE SEQUENCE HR.DEPARTMENTS_SEQ INCREMENT BY 10 MINVALUE 1 MAXVALUE 9990 START WITH 280 NOCACHE;
CREATE SEQUENCE HR.EMPLOYEES_SEQ INCREMENT BY 1 MINVALUE 1 MAXVALUE 9999999999999999999999999999 START WITH 207 NOCACHE;
CREATE SEQUENCE HR.LOCATIONS_SEQ INCREMENT BY 100 MINVALUE 1 MAXVALUE 9900 START WITH 3300 NOCACHE;



/* Create Tables */

-- Departments table that shows details of departments where employees
-- work. Contains 27 rows; references with locations, employees, and job_history tables.
CREATE TABLE HR.DEPARTMENTS
(
	-- Primary key column of departments table.
	DEPARTMENT_ID number(4,0) NOT NULL,
	-- A not null column that shows name of a department. Administration,
	-- Marketing, Purchasing, Human Resources, Shipping, IT, Executive, Public
	-- Relations, Sales, Finance, and Accounting. 
	DEPARTMENT_NAME varchar2(30 char) NOT NULL,
	-- Manager_id of a department. Foreign key to employee_id column of employees table. The manager_id column of the employee table references this column.
	MANAGER_ID number(6),
	-- Location id where a department is located. Foreign key to location_id column of locations table.
	LOCATION_ID number(4,0),
	CONSTRAINT DEPT_ID_PK PRIMARY KEY (DEPARTMENT_ID)
);


-- employees table. Contains 107 rows. References with departments,
-- jobs, job_history tables. Contains a self reference.
CREATE TABLE HR.EMPLOYEES
(
	-- Primary key of employees table.
	EMPLOYEE_ID number(6) NOT NULL,
	-- First name of the employee. A not null column.
	FIRST_NAME varchar2(20 char),
	-- Last name of the employee. A not null column.
	LAST_NAME varchar2(25 char) NOT NULL,
	-- Email id of the employee
	EMAIL varchar2(25 char) NOT NULL UNIQUE,
	-- Phone number of the employee; includes country code and area code
	PHONE_NUMBER varchar2(20 char),
	-- Date when the employee started on this job. A not null column.
	HIRE_DATE date NOT NULL,
	-- Current job of the employee; foreign key to job_id column of the
	-- jobs table. A not null column.
	JOB_ID varchar2(10 char) NOT NULL,
	-- Monthly salary of the employee. Must be greater
	-- than zero (enforced by constraint emp_salary_min)
	SALARY number(8,2),
	-- Commission percentage of the employee; Only employees in sales
	-- department elgible for commission percentage
	COMMISSION_PCT number(2,2),
	-- Manager id of the employee; has same domain as manager_id in
	-- departments table. Foreign key to employee_id column of employees table.
	-- (useful for reflexive joins and CONNECT BY query)
	MANAGER_ID number(6),
	-- Department id where employee works; foreign key to department_id
	-- column of the departments table
	DEPARTMENT_ID number(4,0),
	CONSTRAINT EMP_EMP_ID_PK PRIMARY KEY (EMPLOYEE_ID)
);



/* Create Foreign Keys */

ALTER TABLE HR.EMPLOYEES
	ADD CONSTRAINT EMP_DEPT_FK FOREIGN KEY (DEPARTMENT_ID)
	REFERENCES HR.DEPARTMENTS (DEPARTMENT_ID)
;


ALTER TABLE HR.DEPARTMENTS
	ADD CONSTRAINT DEPT_MGR_FK FOREIGN KEY (MANAGER_ID)
	REFERENCES HR.EMPLOYEES (EMPLOYEE_ID)
;


ALTER TABLE HR.EMPLOYEES
	ADD CONSTRAINT EMP_MANAGER_FK FOREIGN KEY (MANAGER_ID)
	REFERENCES HR.EMPLOYEES (EMPLOYEE_ID)
;



/* Create Triggers */

-- secure_employees
--   BEFORE INSERT OR UPDATE OR DELETE ON employees
-- 
CREATE OR REPLACE TRIGGER HR.SECURE_EMPLOYEES BEGIN
  secure_dml;
END secure_employees;;

/

-- update_job_history
--   AFTER UPDATE OF job_id, department_id ON employees
--   FOR EACH ROW
-- 
CREATE OR REPLACE TRIGGER HR.UPDATE_JOB_HISTORY BEGIN
  add_job_history(:old.employee_id, :old.hire_date, sysdate,
                  :old.job_id, :old.department_id);
END;;

/




/* Create Views */

CREATE OR REPLACE VIEW HR.EMP_DETAILS_VIEW AS SELECT
  e.employee_id,
  e.job_id,
  e.manager_id,
  e.department_id,
  d.location_id,
  l.country_id,
  e.first_name,
  e.last_name,
  e.salary,
  e.commission_pct,
  d.department_name,
  j.job_title,
  l.city,
  l.state_province,
  c.country_name,
  r.region_name
FROM
  employees e,
  departments d,
  jobs j,
  locations l,
  countries c,
  regions r
WHERE e.department_id = d.department_id
  AND d.location_id = l.location_id
  AND l.country_id = c.country_id
  AND c.region_id = r.region_id
  AND j.job_id = e.job_id
WITH READ ONLY;



/* Create Indexes */

CREATE INDEX DEPT_LOCATION_IX ON HR.DEPARTMENTS (LOCATION_ID);
CREATE INDEX EMP_DEPARTMENT_IX ON HR.EMPLOYEES (DEPARTMENT_ID);
CREATE INDEX EMP_JOB_IX ON HR.EMPLOYEES (JOB_ID);
CREATE INDEX EMP_MANAGER_IX ON HR.EMPLOYEES (MANAGER_ID);
CREATE INDEX EMP_NAME_IX ON HR.EMPLOYEES (LAST_NAME, FIRST_NAME);



/* Comments */

COMMENT ON TABLE HR.DEPARTMENTS IS 'Departments table that shows details of departments where employees
work. Contains 27 rows; references with locations, employees, and job_history tables.';
COMMENT ON COLUMN HR.DEPARTMENTS.DEPARTMENT_ID IS 'Primary key column of departments table.';
COMMENT ON COLUMN HR.DEPARTMENTS.DEPARTMENT_NAME IS 'A not null column that shows name of a department. Administration,
Marketing, Purchasing, Human Resources, Shipping, IT, Executive, Public
Relations, Sales, Finance, and Accounting. ';
COMMENT ON COLUMN HR.DEPARTMENTS.MANAGER_ID IS 'Manager_id of a department. Foreign key to employee_id column of employees table. The manager_id column of the employee table references this column.';
COMMENT ON COLUMN HR.DEPARTMENTS.LOCATION_ID IS 'Location id where a department is located. Foreign key to location_id column of locations table.';
COMMENT ON TABLE HR.EMPLOYEES IS 'employees table. Contains 107 rows. References with departments,
jobs, job_history tables. Contains a self reference.';
COMMENT ON COLUMN HR.EMPLOYEES.EMPLOYEE_ID IS 'Primary key of employees table.';
COMMENT ON COLUMN HR.EMPLOYEES.FIRST_NAME IS 'First name of the employee. A not null column.';
COMMENT ON COLUMN HR.EMPLOYEES.LAST_NAME IS 'Last name of the employee. A not null column.';
COMMENT ON COLUMN HR.EMPLOYEES.EMAIL IS 'Email id of the employee';
COMMENT ON COLUMN HR.EMPLOYEES.PHONE_NUMBER IS 'Phone number of the employee; includes country code and area code';
COMMENT ON COLUMN HR.EMPLOYEES.HIRE_DATE IS 'Date when the employee started on this job. A not null column.';
COMMENT ON COLUMN HR.EMPLOYEES.JOB_ID IS 'Current job of the employee; foreign key to job_id column of the
jobs table. A not null column.';
COMMENT ON COLUMN HR.EMPLOYEES.SALARY IS 'Monthly salary of the employee. Must be greater
than zero (enforced by constraint emp_salary_min)';
COMMENT ON COLUMN HR.EMPLOYEES.COMMISSION_PCT IS 'Commission percentage of the employee; Only employees in sales
department elgible for commission percentage';
COMMENT ON COLUMN HR.EMPLOYEES.MANAGER_ID IS 'Manager id of the employee; has same domain as manager_id in
departments table. Foreign key to employee_id column of employees table.
(useful for reflexive joins and CONNECT BY query)';
COMMENT ON COLUMN HR.EMPLOYEES.DEPARTMENT_ID IS 'Department id where employee works; foreign key to department_id
column of the departments table';




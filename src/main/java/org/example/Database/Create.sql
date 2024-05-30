DROP DATABASE IF EXISTS sql_employees;
CREATE DATABASE sql_employees;
\c sql_employees
SET CLIENT_ENCODING TO 'UTF8';

CREATE TABLE employee (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  age INT NOT NULL,
  salary INT NOT NULL,
  address VARCHAR(75) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  gender CHAR(1) NOT NULL
);

CREATE TABLE employee_passwords (
  employee_id INT PRIMARY KEY,
  password VARCHAR(50) NOT NULL,
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);

CREATE TABLE user_roles (
  role_id SERIAL PRIMARY KEY,
  employee_id INT NOT NULL,
  role_type VARCHAR(5) CHECK (role_type IN ('admin', 'user')),
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);

CREATE TABLE employee_holidays (
  holiday_id SERIAL PRIMARY KEY,
  employee_id INT NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  status VARCHAR(8),
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);

CREATE TABLE employee_meetings (
  meeting_id SERIAL PRIMARY KEY,
  employee_id INT NOT NULL,
  date DATE NOT NULL,
  start_time CHAR(5) NOT NULL,
  end_time CHAR(5) NOT NULL,
  status VARCHAR(8),
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);

-- insert into tables


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

INSERT INTO employee (first_name, last_name, age, salary, address, phone_number, gender)
VALUES
('John', 'Doe', 30, 50000, '123 Elm St', '555-1234', 'M'),
('Jane', 'Smith', 25, 60000, '456 Oak St', '555-5678', 'F'),
('Admin', 'User', 40, 100000, '789 Pine St', '555-0000', 'M');

INSERT INTO employee_passwords (employee_id, password)
VALUES
(1, 'password1'),
(2, 'password2'),
(3, 'adminpassword');

INSERT INTO user_roles (employee_id, role_type)
VALUES
(1, 'user'),
(2, 'user'),
(3, 'admin');

INSERT INTO employee_holidays (employee_id, start_date, end_date, status)
VALUES
(1, '2024-06-01', '2024-06-10', 'Pending'),
(2, '2024-07-15', '2024-07-20', 'Approved');

INSERT INTO employee_meetings (employee_id, date, start_time, end_time, status)
VALUES
(1, '2024-06-15', '10:00', '11:00', 'Pending'),
(2, '2024-07-25', '14:00', '15:00', 'Approved');

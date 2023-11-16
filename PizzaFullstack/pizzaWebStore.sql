-- Host: localhost
-- Generation Time: Nov 16, 2023 at 13:50

-- Create database
CREATE SCHEMA pizza_management;

-- Switch to the created database
USE pizza_management;

-- Create Tables
CREATE TABLE admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    adminID VARCHAR(255),
    password VARCHAR(255),
    name VARCHAR(255),
    role VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE pizza (
    pid INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(255),
    side VARCHAR(255),
    drink VARCHAR(255),
    cust_name VARCHAR(255),
    admin_id INT, 
    server VARCHAR(255),
    price INT,
    FOREIGN KEY (admin_id) REFERENCES admin(id) 
);

-- Initialize tables with dummy values (OPTIONAL)

-- admin
INSERT INTO admin(adminID, password, name, role, email) VALUES('admin1', 'pass1', 'Nam', 'Staff', 'staff1@gmail.com');
INSERT INTO admin(adminID, password, name, role, email) VALUES('admin2', 'pass2', 'Tran', 'General Manager', 'manager@gmail.com');
INSERT INTO admin(adminID, password, name, role, email) VALUES('admin3', 'pass3', 'Cuong', 'Vice Manager', 'staff2@gmail.com');
INSERT INTO admin(adminID, password, name, role, email) VALUES('admin4', 'pass4', 'NhuY', 'Director', 'director@gmail.com');
INSERT INTO admin(adminID, password, name, role, email) VALUES('admin5', 'pass5', 'Tom', 'Staff', 'staff3@gmail.com');
INSERT INTO admin(adminID, password, name, role, email) VALUES('admin6', 'pass6', 'John', 'Staff', 'staff4@gmail.com');

-- pizza (orders table)
INSERT INTO pizza(type, side, drink, cust_name, admin_id, server, price) VALUES('Meat Lover', 'veggies', 'pepsi', 'Cust1', 1, 'Nam', 25); -- Use the correct admin ID
INSERT INTO pizza(type, side, drink, cust_name, admin_id, server, price) VALUES('Cheese Pizza', 'wings', 'fanta', 'Cust2', 2, 'Tran', 12); -- Use the correct admin ID
INSERT INTO pizza(type, side, drink, cust_name, admin_id, server, price) VALUES('Pepperoni Pizza', 'fries', 'coke', 'Cust3', 3, 'Cuong', 36); -- Use the correct admin ID
INSERT INTO pizza(type, side, drink, cust_name, admin_id, server, price) VALUES('Cheesy Baked', 'Salad', 'coconut', 'Cust4', 4, 'NhuY', 23); -- Use the correct admin ID

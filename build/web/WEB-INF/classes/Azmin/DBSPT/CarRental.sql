DROP DATABASE IF EXISTS carrental;
CREATE DATABASE carrental;
USE carrental;

CREATE TABLE users(
 userID INT,
 username VARCHAR(50),
 email VARCHAR(50),
 phone VARCHAR(15),
 Address VARCHAR(50),
CONSTRAINT PK_users PRIMARY KEY(userID)
);

CREATE TABLE cars(
carID VARCHAR(50),
carType ENUM('TOYOTA','FORD','KIA','TESLA'),
model VARCHAR(50),
pricePerDay VARCHAR(50),
availability ENUM('AVAILABLE','NOTAVAILABLE'),
CONSTRAINT PK_cars PRIMARY KEY(carID)
);

CREATE TABLE bookings(
bookingID INT,
username VARCHAR(50),
pricePerDay VARCHAR(50),
pickup DATE,
dropoff DATE,
carID VARCHAR(50),
totalCost DOUBLE,
CONSTRAINT PK_bookings PRIMARY KEY(bookingID),
CONSTRAINT FK_bookings FOREIGN KEY(carID) REFERENCES cars(carID)
);





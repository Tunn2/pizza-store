USE UserManagement

DROP TABLE Mobiles

CREATE TABLE Mobiles (
	mobileID varchar(10) PRIMARY KEY,
	description varchar(250) NOT NULL,
	price float,
	mobileName varchar(20) NOT NULL,
	yearOfProduct int,
	quantity int,
	notSale bit
)

INSERT INTO Mobiles VALUES  ('M01', 'Day la dien thoai', 1000, 'Iphone 10', 2022, 100, 0),
							('M02', 'Day la dien thoai', 2000, 'Iphone 11', 2022, 100, 0),
							('M03', 'Day la dien thoai', 3000, 'Iphone 12', 2022, 100, 0),
							('M04', 'Day la dien thoai', 4000, 'Iphone 13', 2022, 100, 0),
							('M05', 'Day la dien thoai', 5000, 'Iphone 14', 2022, 100, 0),
							('M06', 'Day la dien thoai', 6000, 'Iphone 15', 2022, 100, 0),
							('M07', 'Day la dien thoai', 7000, 'Iphone 16', 2022, 100, 0),
							('M08', 'Day la dien thoai', 8000, 'Iphone 17', 2022, 100, 0)

DROP TABLE Users

CREATE TABLE Users (
	userID varchar(20) PRIMARY KEY,
	password int NOT NULL,
	fullName varchar(50) NOT NULL,
	role bit
)

INSERT INTO Users VALUES    ('tungnk', '1', 'Nguyen Khanh Tung', 0),
							('tungnk1', '1', 'Nguyen Khanh Tung1', 0),
							('tungnk2', '1', 'Nguyen Khanh Tung2', 0),
							('tungnk3', '1', 'Nguyen Khanh Tung3', 0),
							('tungnk4', '1', 'Nguyen Khanh Tung4', 0)
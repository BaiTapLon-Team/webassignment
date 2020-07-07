CREATE DATABASE webdesign3st
GO
USE webdesign3st

CREATE TABLE userweb (
	userid INT PRIMARY KEY IDENTITY(1,1),
	useremail VARCHAR(255),
	userpassword NVARCHAR(255),
	username NVARCHAR(255),
	birthday DATE,
	user_role INT
)
GO

CREATE TABLE category1 (
	categoryid1 INT PRIMARY KEY IDENTITY(1,1),
	categoryname NVARCHAR(255)
)
GO

CREATE TABLE category2 (
	categoryid2 INT PRIMARY KEY IDENTITY(1,1),
	categoryid1 INT FOREIGN KEY REFERENCES dbo.category1(categoryid1),
	categoryname NVARCHAR(255)
)
go


CREATE TABLE product (
	productid INT IDENTITY(1,1) PRIMARY KEY,
	adminid INT NOT NULL FOREIGN KEY REFERENCES dbo.userweb(userid),
	categoryid1 INT NOT NULL FOREIGN KEY REFERENCES dbo.category1(categoryid1),
	productname NVARCHAR(255),
	productprice FLOAT,
	productdescription NTEXT
)
go

CREATE TABLE productimages (
	productid INT FOREIGN KEY REFERENCES dbo.product(productid),
	productimage1 NVARCHAR(255),
	productimage2 NVARCHAR(255),
	productimage3 NVARCHAR(255),
	productimage4 NVARCHAR(255),
	productimage5 NVARCHAR(255)
)
go

CREATE TABLE colors (
	productid INT FOREIGN KEY REFERENCES dbo.product(productid),
	color1 NVARCHAR(255),
	color2 NVARCHAR(255),
	color3 NVARCHAR(255),
	color4 NVARCHAR(255),
	color5 NVARCHAR(255)
)
GO


CREATE TABLE sizes (
	productid INT FOREIGN KEY REFERENCES dbo.product(productid),
	size1 NVARCHAR(255),
	size2 NVARCHAR(255),
	size3 NVARCHAR(255),
	size4 NVARCHAR(255),
	size5 NVARCHAR(255)
)
go

CREATE TABLE cart (
	cartid INT PRIMARY KEY IDENTITY(1,1),
	userid INT FOREIGN KEY REFERENCES dbo.userweb(userid),
	total FLOAT,
	producttotal INT
)
go

CREATE TABLE cartdetail (
	productid INT FOREIGN KEY REFERENCES dbo.product(productid),
	cartid INT FOREIGN KEY REFERENCES dbo.cart(cartid),
	amount INT
)
go

CREATE TABLE bill
(
    billid INT PRIMARY KEY IDENTITY(1,1),
	cartid INT FOREIGN KEY REFERENCES dbo.cart(cartid),
	total FLOAT,
	payment NVARCHAR(255),
	datepurchase DATE,
	addressuser NVARCHAR(255) 
)




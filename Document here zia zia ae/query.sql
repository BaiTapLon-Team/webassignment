CREATE DATABASE webdesign3st
GO
USE webdesign3st

CREATE TABLE userweb (
	userid INT PRIMARY KEY IDENTITY(1,1),
	useremail VARCHAR(255),
	userpassword NVARCHAR(255),
	username NVARCHAR(255),
	birthday DATE,
	user_role INT,
	avatar NVARCHAR(255)
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

CREATE TABLE productimages (
	productimgid INT IDENTITY(1,1) PRIMARY KEY,
	productimage1 NVARCHAR(255),
	productimage2 NVARCHAR(255),
	productimage3 NVARCHAR(255),
	productimage4 NVARCHAR(255),
	productimage5 NVARCHAR(255)
)
go

CREATE TABLE product (
	productid INT IDENTITY(1,1) PRIMARY KEY,
	adminid INT NOT NULL FOREIGN KEY REFERENCES dbo.userweb(userid),
	categoryid2 INT NOT NULL FOREIGN KEY REFERENCES dbo.category2(categoryid2),
	productimgid INT NOT NULL FOREIGN KEY REFERENCES dbo.productimages(productimgid),
	productname NVARCHAR(255),
	productprice FLOAT,
	productdescription NTEXT,
	cpu NVARCHAR(255),
	ram NVARCHAR(255),
	harddisk NVARCHAR(255),
	vga NVARCHAR(255),
	screen NVARCHAR(255),
	portconnect NVARCHAR(255),
	weigth NVARCHAR(255),
	pin NVARCHAR(255),
	os NVARCHAR(255)
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

INSERT INTO dbo.category1
(
    categoryname
)
VALUES
(N'Laptop văn phòng'),
(N'Laptop gamming' ),
(N'Laptop workstation')

INSERT INTO dbo.category2
(
    categoryid1,
    categoryname
)
VALUES
(   1, N'Laptop hp'),
(   1, N'Laptop dell'),
(   1, N'Laptop asus')

INSERT INTO dbo.userweb
(
    useremail,
    userpassword,
    username,
    birthday,
    user_role,
    avatar
)
VALUES
(   'tranhaj2024@gmail.com',
    N'Vanhajvst123',
    N'tranhaj2024',
    GETDATE(), -- birthday - date
    1,         -- user_role - int
    N''        -- avatar - nvarchar(255)
    )

INSERT INTO dbo.productimages
(
   
    productimage1,
    productimage2,
    productimage3,
    productimage4,
    productimage5
)
VALUES
(
    N'1', -- productimage1 - nvarchar(255)
    N'1', -- productimage2 - nvarchar(255)
    N'1', -- productimage3 - nvarchar(255)
    N'1', -- productimage4 - nvarchar(255)
    N'1'  -- productimage5 - nvarchar(255)
    )

INSERT INTO dbo.product
(
    adminid,
    categoryid2,
	productimgid,
    productname,
    productprice,
    productdescription,
    cpu,
    ram,
    harddisk,
    vga,
    screen,
    portconnect,
    weigth,
    pin,
    os
)
VALUES
(   1,   -- adminid - int
    2,   -- categoryid2 - int
	1, 
    N'Tên Máy Tính', -- productname - nvarchar(255)
    15000000.0, -- productprice - float
    N'Miêu tả máy : Khá là ngon', -- productdescription - ntext
    N'i9 9999HQ', -- cpu - nvarchar(255)
    N'32gb', -- ram - nvarchar(255)
    N'SSD 512GB', -- harddisk - nvarchar(255)
    N'K1000M', -- vga - nvarchar(255)
    N'Full HD', -- screen - nvarchar(255)
    N'USB, VGA, HDMI', -- portconnect - nvarchar(255)
    N'1.6kg', -- weigth - nvarchar(255)
    N'9 tiếng', -- pin - nvarchar(255)
    N'Windowns 12'  -- os - nvarchar(255)
    )

	SELECT * FROM dbo.category2
	SELECT * FROM dbo.product
	SELECT * FROM dbo.userweb

	SELECT * FROM dbo.productimages

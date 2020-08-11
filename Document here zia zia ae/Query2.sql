CREATE DATABASE WebDesign

GO

CREATE TABLE [ProductImages] (
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Image1 NVARCHAR(255),
	Image2 NVARCHAR(255),
	Image3 NVARCHAR(255),
	Image4 NVARCHAR(255),
	Image5 NVARCHAR(255),
	Image6 NVARCHAR(255)
)

Go

CREATE TABLE [Category]
(
	Id INT PRIMARY KEY IDENTITY(1, 1),
	ParentId INT,
	Name NVARCHAR(255)
)

Go

CREATE TABLE [Product]
(
	Id int PRIMARY KEY IDENTITY(1,1),
	Name NVARCHAR(255),
	Price DECIMAL,
	CategoryId int FOREIGN KEY REFERENCES Category(Id),
	Description NTEXT,
	CreatedOn DATETIME,
	ModifiedOn DATETIME,
	Status NVARCHAR(255),
	Cpu NVARCHAR(255),
	Ram NVARCHAR(255),
	HardDisk NVARCHAR(255),
	Screen NVARCHAR(255),
	PortConnect NVARCHAR(255),
	Weight NVARCHAR(255),
	Pin NVARCHAR(255),
	Os NVARCHAR(255),
	BusRam NVARCHAR(255),
	Brand NVARCHAR(255),
	ProductImagesId int FOREIGN KEY REFERENCES ProductImages(Id),
)

INSERT INTO Product(Name, Description,HardDisk) values 
('Oke', 'Van cu la oke', 'Ngon lành rồi')

Go

CREATE TABLE [ORDER]
(
	Id int PRIMARY KEY IDENTITY(1,1),
	TotalAmount DECIMAL,
	CreatedOn DATETIME,
	ModifiedOn DATETIME,
	Status NVARCHAR(255),
	NameCustomer NVARCHAR(255),
	PhoneNumberCustomer NVARCHAR(255),
	EmailCustomer NVARCHAR(255),
	Description NTEXT
)

Go

CREATE TABLE [ORDER_PRODUCT]
(
	OrderId int FOREIGN KEY REFERENCES [ORDER](Id),
	ProductId int FOREIGN KEY REFERENCES Product(Id),
	Quantity int,
	TotalAmount DECIMAL,
	PRIMARY KEY (OrderId, ProductId)
)

Go

Create TABLE [User]
(
	Id int PRIMARY KEY IDENTITY(1,1),
	Email varchar(255),
	PassWord varchar(255),
	UserName NVARCHAR(255),
	BirthDay DATE,
	UserRole Int
)

Go

INSERT INTO Category (ParentId, Name) VALUES
( 0, N'Laptop gaming'),
( 0, N'Laptop đồ họa'),
( 0, N'Laptop mỏng nhẹ'),
( 0, N'Laptop cũ'),
( 0, N'Linh kiện'),
( 1, N'Dell gaming'),
( 1, N'Asus gaming'),
( 1, N'Msi gaming'),
( 1, N'Lenovo gaming'),
( 2, N'Laptop dell'),
( 2, N'Laptop lenovo'),
( 2, N'Laptop hp'),
( 3, N'Laptop dell'),
( 3, N'Laptop lenovo'),
( 3, N'Laptop hp'),
( 4, N'Laptop dell'),
( 4, N'Laptop lenovo'),
( 4, N'Laptop hp'),
( 5, N'Ram'),
( 5, N'Ổ cứng'),
( 5, N'Chuột máy tính')

SELECT * FROM Category

--Drop Table ORDER_PRODUCT
--Drop Table [ORDER]
--Drop Table Product
--Drop Table ProductImages
--Drop Table Categories

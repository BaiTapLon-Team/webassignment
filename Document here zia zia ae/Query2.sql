CREATE DATABASE WebDesign

USE WebDesign

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

insert into ProductImages values
('https://laptopaz.vn/media/product/120_1408_dell_5577__3_.jpg', 
	'https://laptopaz.vn/media/product/120_1408_5ad51fe832d0d48e8dc1.jpg',
	'https://laptopaz.vn/media/product/120_1408_dell_5577__13_.jpg',
	'https://laptopaz.vn/media/product/120_1408_dell_5577__7_.jpg',
	'https://laptopaz.vn/media/product/120_1408_dell_5577__5_.jpg',
	'https://laptopaz.vn/media/product/120_1408_dell_5577__4_.jpg'
)

select * from ProductImages

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


update Product SET ProductImagesId = 1 where id  = 3

INSERT INTO Product(Name,Price, CategoryId, Description, Status, Cpu, Ram, HardDisk, Screen, PortConnect, Weight, Pin, Os, BusRam, Brand) values 
('Lap top dell 7559 i5', 5000, 11, 'May tinh ngon', 'active', 'i5 7300hq', '8G', '500GB ssd', '15.6 inch', 'hdmi', '2.5kg', '6 cell', 'windows', '1600', 'dell')



select * from Product

Go

CREATE TABLE [OrderTshop]
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

CREATE TABLE [OrderProduct]
(
	OrderId int FOREIGN KEY REFERENCES [OrderTshop](Id),
	ProductId int FOREIGN KEY REFERENCES Product(Id),
	Quantity int,
	TotalAmount DECIMAL,
	PRIMARY KEY (OrderId, ProductId)
)

select * from [OrderTshop];
select * from OrderProduct

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

Drop Table OrderProduct
Drop Table [Order]
--Drop Table Product
--Drop Table ProductImages
--Drop Table Categories

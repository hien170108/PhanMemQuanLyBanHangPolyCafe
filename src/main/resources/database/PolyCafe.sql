create database Polycafe
go
use Polycafe
go

CREATE TABLE Categories(
    Id NVARCHAR(20) NOT NULL,
    Name NVARCHAR(50) NOT NULL,
    PRIMARY KEY(Id)
)

CREATE TABLE Drinks(
    Id NVARCHAR(20) NOT NULL,
    Name NVARCHAR(50) NOT NULL,
    UnitPrice FLOAT NOT NULL,
    Discount FLOAT NOT NULL,
    Image NVARCHAR(50) NOT NULL,
    Available BIT NOT NULL,
    CategoryId NVARCHAR(20) NOT NULL,
    PRIMARY KEY(Id),
    FOREIGN KEY(CategoryId) REFERENCES Categories(Id) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
)

CREATE TABLE Cards(
    Id INT NOT NULL,
    Status INT NOT NULL,
    PRIMARY KEY(Id)
)

CREATE TABLE Users(
    Username NVARCHAR(20) NOT NULL,
    Password NVARCHAR(50) NOT NULL,
    Enabled BIT NOT NULL,
    Fullname NVARCHAR(50) NOT NULL,
    Photo NVARCHAR(50) NOT NULL,
    Manager BIT NOT NULL,
	Email NVARCHAR(100) NOT NULL,
    PRIMARY KEY(Username)
)

CREATE TABLE Bills(
    Id BIGINT NOT NULL IDENTITY(10000, 1),
    Username NVARCHAR(20) NOT NULL,
    CardId INT NOT NULL,
    Checkin DATETIME NOT NULL,
    Checkout DATETIME NULL,
    Status INT NOT NULL,
    PRIMARY KEY(Id),
    FOREIGN KEY(Username) REFERENCES Users(Username) 
        ON UPDATE CASCADE,
    FOREIGN KEY(CardId) REFERENCES Cards(Id) 
        ON UPDATE CASCADE
)

CREATE TABLE BillDetails(
    Id BIGINT NOT NULL IDENTITY(100000, 1),
    BillId BIGINT NOT NULL,
    DrinkId NVARCHAR(20) NOT NULL,
    UnitPrice FLOAT NOT NULL,
    Discount FLOAT NOT NULL,
    Quantity INT NOT NULL,
    PRIMARY KEY(Id),
    FOREIGN KEY(BillId) REFERENCES Bills(Id) 
        ON DELETE CASCADE,
    FOREIGN KEY(DrinkId) REFERENCES Drinks(Id) 
        ON UPDATE CASCADE
)
CREATE TABLE ChatMessages (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    SenderUsername NVARCHAR(20) NOT NULL,
    Content NVARCHAR(MAX) NOT NULL,
    Timestamp DATETIME DEFAULT GETDATE(),
    IsRead BIT DEFAULT 0,
    FOREIGN KEY (SenderUsername) REFERENCES Users(username)
)
CREATE TABLE ActivityLogs (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(20) NOT NULL,
    Action NVARCHAR(100) NOT NULL,
    Details NVARCHAR(MAX),
    Timestamp DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (Username) REFERENCES Users(Username)
)
go

insert into Users values 
('a','1234$',1,'NgoQuangHien','aaa',1,'quanghien1701@gmail.com'),
('b','1234$',1,'NgoQuangHien2','aaa',0,'hiennqth06730@gmail.com')

select * from Users

DROP TABLE IF EXISTS ChatMessages;
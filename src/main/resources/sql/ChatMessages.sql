CREATE TABLE ChatMessages (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    SenderUsername VARCHAR(50) NOT NULL,
    Content NVARCHAR(MAX) NOT NULL,
    Timestamp DATETIME NOT NULL,
    IsRead BIT DEFAULT 0,
    FOREIGN KEY (SenderUsername) REFERENCES Users(Username)
); 
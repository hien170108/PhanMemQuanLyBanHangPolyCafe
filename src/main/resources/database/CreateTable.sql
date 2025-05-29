-- Create ChatMessages table
CREATE TABLE ChatMessages (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Sender NVARCHAR(50) NOT NULL,
    Content NVARCHAR(MAX) NOT NULL,
    Timestamp DATETIME DEFAULT GETDATE(),
    IsRead BIT DEFAULT 0,
    FOREIGN KEY (Sender) REFERENCES Users(Username)
); 
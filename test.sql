CREATE TABLE PUBLISHER (
    Name Varchar(200) PRIMARY KEY,
    Address Varchar(200),
    Phone Decimal(20)
);

CREATE TABLE BORROWER (
    CardNumber Char(4) PRIMARY KEY,
    Name Varchar(200) NOT NULL,
    Address Varchar(400),
    Phone Decimal(20)
);

CREATE TABLE LIBRARY_BRANCH (
    BranchID Char(4) PRIMARY KEY,
    BranchName Varchar(200) NOT NULL,
    Address Varchar(400)
);

CREATE TABLE BOOK (
    BookID Char(4) PRIMARY KEY,
    Title Varchar(200),
    PublisherName Varchar(200),
    FOREIGN KEY (PublisherName) REFERENCES PUBLISHER(Name)
        ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE BOOK_AUTHORS (
    BookID Char(4) NOT NULL,
    AuthorName Varchar(200) NOT NULL,
    PRIMARY KEY (BookID, AuthorName),
    FOREIGN KEY (BookID) REFERENCES Book(BookID)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE BOOK_COPIES (
    BookID Char(4) NOT NULL,
    BranchID Char(4) NOT NULL,
    NumberOfCopies Int DEFAULT 1,

    PRIMARY KEY (BookID, BranchID),
    FOREIGN KEY (BookID) REFERENCES Book(BookID)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (BranchID) REFERENCES LIBRARY_BRANCH(BranchID)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE BOOK_LOANS (
    BookID Char(4) NOT NULL,
    BranchID Char(4) NOT NULL,
    CardNumber Char(4) NOT NULL,
    DateOut Date,
    DueDate Date,

    PRIMARY KEY (BookID, BranchID, CardNumber),
    FOREIGN KEY (BookID) REFERENCES Book(BookID)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (BranchID) REFERENCES LIBRARY_BRANCH(BranchID)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (CardNumber) REFERENCES BORROWER(CardNumber)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

INSERT INTO `PUBLISHER` (`Name`, `Address`, `Phone`) VALUES
    ('Picador', 'London, United Kingdom', '123456'),
    ('Bloomsbury', 'London, United Kingdom', '453216'),
    ('Doubleday', 'New York, United States', '9786456');

INSERT INTO `LIBRARY_BRANCH` (`BranchId`, `BranchName`, `Address`) VALUES
    ('br1', 'Sharpstown', 'Sharpstown USA'),
    ('br2', 'Central', 'Central USA'),
    ('br3', 'Morristown', 'Morristown USA');

INSERT INTO `BORROWER` (`CardNumber`, `Name`, `Address`, `Phone`) VALUES
    ('c1', 'Ron',  'Arizona', '1234567'),
    ('c2', 'Stephan',  'Texas', '6745329'),
    ('c3', 'Ian',  'California', '534261');

INSERT INTO `BOOK` (`BookID`, `Title`, `PublisherName`) VALUES
    ('b1', 'The Lost Tribe', 'Picador'),
    ('b2', 'Harry Potter', 'Bloomsbury'),
    ('b3', 'The Shining', 'Doubleday'),
    ('b4', 'The Outsider', 'Doubleday'),
    ('b5', 'Pet Sematary', 'Doubleday'),
    ('b6', 'The Stand', 'Doubleday');


INSERT INTO `BOOK_AUTHORS` (`BookID`, `AuthorName`) VALUES
    ('b1', 'Mark Lee'),
    ('b2', 'J. K. Rowling'),
    ('b3', 'Stephen King');

INSERT INTO `BOOK_COPIES` (`BookID`, `BranchID`, `NumberOfCopies`) VALUES
    ('b1', 'br1', 5),
    ('b1', 'br2', 15),
    ('b1', 'br3', 2),
    ('b3', 'br2', 10);

INSERT INTO `BOOK_LOANS` (`BookID`, `BranchId`, `CardNumber`, `DateOut`, `DueDate`) VALUES
    ('b1', 'br1', 'c1',  '2018-08-01',  '2018-08-30'),
    ('b2', 'br2', 'c1',  '2018-07-23',  '2018-08-21'),
    ('b2', 'br3', 'c1',  '2018-08-08',  '2018-09-10'),
    ('b3', 'br1', 'c1',  '2018-09-01',  '2018-09-29'),
    ('b5', 'br2', 'c1',  '2019-12-21',  '2020-01-05'),
    ('b6', 'br3', 'c1',  '2019-12-19',  '2020-01-07'),
    ('b2', 'br1', 'c2',  '2018-09-23',  '2018-10-21');



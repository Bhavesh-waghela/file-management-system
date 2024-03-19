CREATE TABLE FILEMETADATA (
    id int auto_increment,
    path varchar(255),
    filename varchar(255),
    extension varchar(255),
    size int,
    createdDate Date,
    lastScannedDate Date
);
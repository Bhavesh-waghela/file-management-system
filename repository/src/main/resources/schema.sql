CREATE TABLE FILEMETADATA (
    Id int auto_increment,
    path varchar(255),
    filename varchar(255),
    extension varchar(255),
    size int,
    created_date Date,
    last_scanned_date Date
);

 insert into FILEMETADATA(path,filename,extension, size,created_date,last_scanned_date)
 values ('/test/path','dummy.txt','.txt', null, null , null );
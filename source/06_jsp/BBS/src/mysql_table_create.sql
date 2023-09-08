use BBS;

create table BBS (
	bbsID int,
    bbsTitle varchar(50),
    userID varchar(20),
    bbsDate datetime,
    bbsContent varchar(2048),
    bbsAvailable int,
    
    #bbsAvailable : 삭제여부
use BBS;

create table BBS (
	bbsID int,
    bbsTitle varchar(50),
    userID varchar(20),
    bbsDate datetime,
    bbsContent varchar(2048),
    bbsAvailable int,
    primary key (bbsID)
    );
    
    #bbsAvailable : 삭제여부
    
    select * from BBS;
    
    select * from BBS where bbsAvailable =1;
    

    
update BBS set bbsAvailable = 1 where bbsID = 0;
select * from user;
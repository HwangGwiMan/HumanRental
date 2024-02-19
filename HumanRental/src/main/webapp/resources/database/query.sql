CREATE DATABASE HumanRental DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;


use HumanRental;


-- 회원관리
CREATE TABLE IF NOT EXISTS Member(
memberId varchar(20) not null primary key,
memberPw varchar(20) not null,
name varchar(20) not null,
age int not null,
gender varchar(10) not null,
phone int not null,
address varchar(100) not null,
nickname varchar(20) not null,
profileImage varchar(20)
);

INSERT INTO Member VALUES("admin", "admin", "admin", 1, "TEST", 01000000000, "TEST", "admin", "default.png");

-- 멘토 신청 정보 테이블
CREATE TABLE IF NOT EXISTS MentorRegistInfo(
	registId varchar(50) not null primary key,
	memberId varchar(20) not null,
    specialty varchar(255),
    location varchar(255),
    reason varchar(255),
    etc varchar(1000),
    foreign key(memberId) references Member(memberId)
);

-- 멘토프로필관리 
CREATE TABLE IF NOT EXISTS MentorProfile(
mentorId varchar(20) not null primary key,
memberId varchar(20) not null,
introduction varchar(1000) not null,
starRate int,
foreign key(memberId) references Member(memberId)
);


-- 멘티프로필 관리
CREATE TABLE IF NOT EXISTS MenteeProfile(
menteeId varchar(20) not null primary key,
memberId varchar(20) not null,
introduction varchar(1000)not null,
starRate int,
foreign key(memberId) references Member(memberId)
);


-- 팝니다 관리 
CREATE TABLE IF NOT EXISTS Selling(
sellingId varchar(20) not null primary key,
memberId varchar(20) not null,
information varchar(1000) not null,
price int ,
location varchar(50) not null,
createDate date,
foreign key(memberId) references Member(memberId)
);

-- 삽니다 관리 
CREATE TABLE IF NOT EXISTS Buying(
buyingId varchar(20) not null primary key,
memberId varchar(20) not null,
information varchar(1000) not null,
price int,
location varchar(50) not null,
createDate date,
foreign key(memberId) references Member(memberId)

); 

-- 찜목록 
CREATE TABLE IF NOT EXISTS Save(
saveListId varchar(20) not null primary key,
sellingId varchar(20)not null ,
memberId varchar(20) not null,
content varchar(10000),
createDate date,
foreign key(memberId) references Member(memberId),
foreign key(sellingId) references Selling(sellingId)
);

-- 후기관리
-- 팝니다 리뷰 -
CREATE TABLE IF NOT EXISTS SellingReview(
sellingReviewId varchar(20) not null primary key,
memberId varchar(20)not null ,
sellingId varchar(20)not null,
content varchar(10000),
writeDate date,
starRate int,
foreign key(memberId) references Member(memberId),
foreign key(sellingId) references Selling(sellingId)
);

-- 삽니다 리뷰 
CREATE TABLE IF NOT EXISTS BuyingReview(
buyingReviewId varchar(20) not null primary key,
memberId varchar(20) not null,
buyingId varchar(20) not null,
content varchar(10000),
writeDate date,
starRate int,
foreign key(memberId) references Member(memberId),
foreign key(buyingId) references Buying(buyingId)
);

-- 예약 관리 
CREATE TABLE IF NOT EXISTS SellAndBuyId(
contentId varchar(20) not null primary key

);
CREATE TABLE IF NOT EXISTS Reservation(
reservationId varchar(20) not null primary key,
menteeId varchar(20)not null,
mentorId varchar(20)not null,
contentId varchar(100)not null,
memberId varchar(20)not null,
signDate date,
content varchar(10000),
foreign key(menteeId) references  MenteeProfile(menteeId),
foreign key(mentorId) references  MentorProfile(mentorId),
foreign key(contentId) references SellAndBuyId(contentId),
foreign key(memberId ) references Member(memberId)
);

-- 알람 관리  이건 좀 나중에 
-- CREATE TABLE IF NOT EXISTS Alarm(
-- member

-- );

-- 일정관리 
CREATE TABLE IF NOT EXISTS Calendar(
calendarId varchar(20) not null primary key,
memberId varchar(20) not null,
calender date,
content varchar(10000),
foreign key(memberId) references Member(memberId)
);

-- 문의 관리 
CREATE TABLE IF NOT EXISTS Question(
questionId varchar(20) not null primary key,
title varchar(100) not null,
content varchar(10000) not null,
category varchar(20)not null,
writeDate date
);

CREATE TABLE IF NOT EXISTS Answer(
answerId varchar(20) not null primary key,
questionId varchar(20) not null,
title varchar(100) not null,
content varchar(10000) not null,
writeDate date,
foreign key(questionId) references Question(questionId)
);

-- 멘토 리스트

-- 멘티 리스트

--  커뮤니티 관리 (자유게시판)
CREATE TABLE IF NOT EXISTS Board(
boardId int primary key auto_increment,
memberId varchar(20) not null,
name varchar(20) not null,
title varchar(100),
content varchar(10000),
regist_day varchar(30) not null,
hit int default 0
);

--  커뮤니티 관리 (공지사항)
CREATE TABLE IF NOT EXISTS Board2(
boardId int primary key auto_increment,
memberId varchar(20) not null,
name varchar(20) not null,
title varchar(100),
content varchar(10000),
regist_day varchar(30) not null,
hit int default 0
);

CREATE TABLE IF NOT EXISTS Notice(
noticeId varchar(20) not null primary key ,
title varchar(100) not null,
content varchar(10000) not null,
writeDate date
);


CREATE TABLE IF NOT EXISTS Comment(
commentId varchar(20) not null primary key,
boardId int not null,
memberId varchar(20) not null,
content varchar(10000) not null,
writeDate date,
foreign key(boardId) references Board(boardId),
foreign key(memberId) references member(memberId) 
);

-- 신고 관리 
CREATE TABLE IF NOT EXISTS Report(
reportId varchar(20) not null primary key,
memberId varchar(20),
title varchar(100),
content varchar(10000),
category varchar(30),
createDate date,
foreign key(memberId) references Member(memberId)
);



-- 블랙리스트 관리 
CREATE TABLE IF NOT EXISTS BlackList(
blackId varchar(20) not null primary key,
memberId varchar(20),
content varchar(10000),
createDate date,
foreign key(memberId) references Member(memberId)
);

-- 알람 관리 


CREATE TABLE IF NOT EXISTS ChatAlarm(
chatalarmId varchar(20) not null primary key

);

CREATE TABLE IF NOT EXISTS MatchAlarm(
matchalarmId varchar(20) not null primary key

);

CREATE TABLE IF NOT EXISTS ScheduleAlarm(
schedulealarmId varchar(20) not null primary key

);

--  CREATE TABLE IF NOT EXISTS Alarm(
-- memberId varchar(20) not null primary key,
-- chatalarmId varchar(20)not null,
-- matchalarmId varchar(20)not null,
-- schedulealarmId varchar(20)not null,
--  date date,
-- content varchar(10000)not null,
-- foreign key(memberId) references Member(memberId) ,
-- foreign key(chatalarmId) references ChatAlarm(chatalarmId), 
-- foreign key(memberId) references MatchAlarm(matchalarmId), 
-- foreign key(schedulealarmId) references ScheduleAlarm(schedulealarmId) 
-- );

CREATE TABLE IF NOT EXISTS Alarm(
alarmId varchar(20) not null primary key,
memberId varchar(20) not null,
date date not null,
content varchar(10000) not null,
foreign key(memberId) references Member(memberId)
);
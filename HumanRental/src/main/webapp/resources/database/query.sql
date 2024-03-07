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
nickname varchar(20) not null unique,
joinDate datetime not null,
profileImage varchar(20),
reportCount int
);

-- 멘토 테이블
CREATE TABLE mentor(
	mentorId varchar(50) primary key,
    memberId varchar(20) unique,
    registDate datetime not null,
    foreign key(memberId) references Member(memberId)
);

-- 멘토 신청 정보 테이블
CREATE TABLE IF NOT EXISTS MentorRegistInfo(
	registId varchar(50) not null primary key,
	memberId varchar(20) not null,
    specialty varchar(255),
    location varchar(255),
    reason varchar(255),
    etc varchar(1000),
    applyDate datetime not null,
    foreign key(memberId) references Member(memberId)
);

-- 멘토 신청 관리 테이블
CREATE TABLE IF NOT EXISTS MentorApply(
	registId varchar(50) not null,
    memberId varchar(20) not null,
    confirmDate datetime,
    state varchar(10) not null,
    foreign key(registId) references MentorRegistInfo(registId),
    foreign key(memberId) references Member(memberId)
);

-- 멘토프로필관리 
CREATE TABLE IF NOT EXISTS MentorProfile(
mentorId varchar(50) not null,
memberId varchar(50) not null,
introduction varchar(1000),
certification varchar(500),
category varchar(100),
filename1 varchar(1000),
filename2 varchar(1000),
filename3 varchar(1000),
starRate int ,
starCount int,
foreign key(memberId) references Member(memberId),
foreign key(mentorId) references mentor(mentorId)
);

-- 멘티프로필 관리
CREATE TABLE IF NOT EXISTS MenteeProfile(
menteeId varchar(50) not null primary key,
memberId varchar(50) not null,
interest varchar(50),
introduction varchar(1000),
starRate int ,
starCount int,
foreign key(memberId) references Member(memberId)
);

-- 팝니다 관리 
CREATE TABLE IF NOT EXISTS Selling (
	sellingId VARCHAR(50) primary key,
	memberId VARCHAR(20),
	nickname VARCHAR(20),
	introduction VARCHAR(1000),
	starRate INT NULL,
	title VARCHAR(20),
	content TEXT NULL,
	regist_day datetime,
    category varchar(10),
    price int,
    location VARCHAR(50),
    starCount int,
	foreign key(memberId) references Member(memberId) ON DELETE CASCADE,
	foreign key(nickname) references Member(nickname) ON DELETE CASCADE
);

-- 삽니다 관리 
CREATE TABLE IF NOT EXISTS Buying (
	buyingId VARCHAR(50) primary key,
	memberId VARCHAR(20),
	nickname VARCHAR(20),
	introduction VARCHAR(1000),
	starRate INT NULL,
	title VARCHAR(20),
	content TEXT NULL,
	regist_day datetime,
    category varchar(10),
    price int,
    location VARCHAR(50),
    starCount int,
	foreign key(memberId) references Member(memberId) ON DELETE CASCADE,
	foreign key(nickname) references Member(nickname) ON DELETE CASCADE
);

-- 찜목록 
CREATE TABLE IF NOT EXISTS Save(
saveListId varchar(50),
memberId varchar(20) not null,
category VARCHAR(20),
nickname varchar(20),
title varchar(50),
price int,
content varchar(1000),
foreign key(memberId) references Member(memberId)

);

-- 후기관리
-- 팝니다 리뷰 -
CREATE TABLE IF NOT EXISTS SellingReview(
sellingReviewId varchar(50) primary key,
sellingId varchar(50),
memberId varchar(20),
title varchar(50),
content varchar(10000),
writeDate date,
starRate int,
foreign key(memberId) references Member(memberId),
foreign key(sellingId) references Selling(sellingId)
);

-- 삽니다 리뷰 
CREATE TABLE IF NOT EXISTS BuyingReview(
buyingReviewId varchar(50) not null primary key,
buyingId varchar(50),
memberId varchar(20) not null,
title varchar(50),
content varchar(10000),
writeDate date,
starRate int,
foreign key(memberId) references Member(memberId),
foreign key(buyingId) references Buying(buyingId)
);

-- 예약 관리 
CREATE TABLE IF NOT EXISTS Reservation(
reservationId varchar(50) primary key,
boardId varchar(50),
title varchar(20),
menteeId varchar(50),
mentorId varchar(50),
reservationDate date,
reservationContent text,
approve varchar(10),
signDate datetime,
memberId varchar(20),
applicantMemberId varchar(20),
regist_day datetime,
completionDate datetime,
foreign key(menteeId) references  MenteeProfile(menteeId),
foreign key(mentorId) references  MentorProfile(mentorId)
);


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

--  커뮤니티 관리 (board1 = 자유게시판, board2 = 공지사항)
CREATE TABLE IF NOT EXISTS Board(
boardId varchar(50) primary key,
memberId varchar(20) not null,
name varchar(20) not null,
title varchar(100),
content varchar(10000),
regist_day datetime not null,
hit int default 0
);

CREATE TABLE IF NOT EXISTS Board2(
boardId varchar(50) primary key,
memberId varchar(20) not null,
name varchar(20) not null,
title varchar(100),
content varchar(10000),
regist_day datetime not null,
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
boardId varchar(50),
memberId varchar(20) not null,
content varchar(10000) not null,
writeDate date,
foreign key(boardId) references Board(boardId),
foreign key(memberId) references member(memberId) 
);

-- 신고 관리 
CREATE TABLE IF NOT EXISTS Report(
reportId varchar(20) not null primary key, -- 신고 ID
memberId varchar(20), -- 신고 당한 멤버 ID
reporterId varchar(20), -- 신고한 멤버 ID
target varchar(20), -- 신고 대상
targetId varchar(50), -- 신고 대상 ID
type varchar(50), -- 신고 유형
state varchar(20),
createDate datetime, -- 신고 날짜
foreign key(memberId) references Member(memberId),
foreign key(reporterId) references Member(memberId)
);



-- 블랙리스트 관리 
CREATE TABLE IF NOT EXISTS BlackList(
blackId varchar(50) not null primary key,
memberId varchar(20) unique,
registDate datetime,
foreign key(memberId) references Member(memberId)
);

-- 알람 관리 

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
alarmId varchar(50) not null primary key,
sendMemberId varchar(20) not null,
receiveMemberId varchar(20) not null,
date datetime not null,
content varchar(10000) not null,
linkId varchar(50),
foreign key(sendMemberId) references Member(memberId),
foreign key(receiveMemberId) references Member(memberId)
);


-- 테스트 데이터
-- 회원 정보 추가
INSERT INTO Member VALUES("admin", "admin", "admin", 1, "TEST", 01000000000, "TEST", "admin", "2024-01-01 12:00:00" , "default.png", 0);
INSERT INTO Member VALUES("qwer", "1234", "김이름", 25, "남", 01000000000, "TEST", "닉네임1", "2024-01-01 12:00:00" , "default.png", 0);
INSERT INTO Member VALUES("asdf", "1234", "박이름", 25, "남", 01000000000, "TEST", "닉네임2", "2024-01-01 12:00:00" , "default.png", 0);
INSERT INTO Member VALUES("zxcv", "1234", "박이름", 25, "남", 01000000000, "TEST", "닉네임3", "2024-01-01 12:00:00" , "default.png", 0);
INSERT INTO Member VALUES("1234", "1234", "박이름", 25, "남", 01000000000, "TEST", "닉네임4", "2024-01-01 12:00:00" , "default.png", 0);
INSERT INTO Member VALUES("5678", "1234", "박이름", 25, "남", 01000000000, "TEST", "닉네임5", "2024-01-01 12:00:00" , "default.png", 0);
INSERT INTO Member VALUES("test_1", "1234", "박이름", 25, "남", 01000000000, "TEST", "닉네임6", "2024-01-01 12:00:00" , "default.png", 0);
INSERT INTO Member VALUES("test_2", "1234", "박이름", 25, "남", 01000000000, "TEST", "닉네임7", "2024-01-01 12:00:00" , "default.png", 0);
INSERT INTO Member VALUES("test_3", "1234", "박이름", 25, "남", 01000000000, "TEST", "닉네임8", "2024-01-01 12:00:00" , "default.png", 0);
INSERT INTO Member VALUES("test_4", "1234", "박이름", 25, "남", 01000000000, "TEST", "닉네임9", "2024-01-01 12:00:00" , "default.png", 0);
INSERT INTO Member VALUES("test_5", "1234", "박이름", 25, "남", 01000000000, "TEST", "닉네임10", "2024-01-01 12:00:00" , "default.png", 0);
INSERT INTO Member VALUES("test_6", "1234", "박이름", 25, "남", 01000000000, "TEST", "닉네임11", "2024-01-01 12:00:00" , "default.png", 0);



-- 자유게시판, 공지사항 내용 추가
insert into board values('Board_001','admin','admin','게시글1','내용','2024-01-01 00:00:00',0);
insert into board values('Board_002','qwer','김이름','게시글2','내용','2024-01-02 00:00:00',0);
insert into board values('Board_003','qwer','김이름','게시글3','내용','2024-01-03 00:00:00',0);
insert into board2 values('Board_001','admin','admin','공지사항1','내용','2024-01-01 00:00:00',0);
insert into board2 values('Board_002','admin','admin','공지사항2','내용','2024-01-02 00:00:00',0);
insert into board2 values('Board_003','admin','admin','공지사항3','내용','2024-01-03 00:00:00',0);

-- mentor 추가
insert into mentor values('mentor_001' , 'qwer', '2024-01-01 00:00:00');
insert into mentor values('mentor_002' , 'admin', '2024-01-01 00:00:00');
insert into mentor values('mentor_003' , 'asdf', '2024-01-01 00:00:00');
insert into mentor values('mentor_004' , 'zxcv', '2024-01-01 00:00:00');
insert into mentor values('mentor_005' , '1234', '2024-01-01 00:00:00');
insert into mentor values('mentor_006' , '5678', '2024-01-01 00:00:00');


-- menteeprofile 추가
insert into menteeprofile values('mentee_001', 'qwer', 'TEST1', 'TEST_INTRO1', 0, 0);
insert into menteeprofile values('mentee_002', 'admin', 'TEST2', 'TEST_INTRO2', 0, 0);
insert into menteeprofile values('mentee_003', 'asdf', 'TEST3', 'TEST_INTRO3', 0, 0);

-- mentorprofile 추가
insert into mentorprofile values('mentor_001' , 'qwer', 'TEST_INTRO1', 'TEST', 'certification_cate', 'TEST', 'TEST', 'TEST', 0, 0);
insert into mentorprofile values('mentor_002' , 'admin', 'TEST_INTRO1', 'TEST', 'certification_cate', 'TEST', 'TEST', 'TEST', 0, 0);
insert into mentorprofile values('mentor_003' , 'asdf', 'TEST_INTRO1', 'TEST', 'certification_cate', 'TEST', 'TEST', 'TEST', 0, 0);

-- buying 내용 추가
insert into buying values('buyingId_001','qwer','닉네임1','introduction',0,'기타 알려주실 분','내용','2024-01-01 00:00:00','music',10000,'한국',0);
insert into buying values('buyingId_002','asdf','닉네임2','introduction',0,'같이 공찰 사람','내용','2024-01-02 00:00:00','sports',20000,'한국',0);
insert into buying values('buyingId_003','asdf','닉네임2','introduction',0,'롤 듀오 구함니다','내용','2024-01-03 00:00:00','game',5000,'한국',0);
insert into buying values('buyingId_004','zxcv','닉네임1','introduction',0,'기타 알려주실 분','내용','2024-01-01 00:00:00','music',10000,'한국',0);
insert into buying values('buyingId_005','1234','닉네임2','introduction',0,'같이 공찰 사람','내용','2024-01-02 00:00:00','sports',20000,'한국',0);
insert into buying values('buyingId_006','5678','닉네임2','introduction',0,'롤 듀오 구함니다','내용','2024-01-03 00:00:00','game',5000,'한국',0);
insert into buying values('buyingId_007','test_1','닉네임1','introduction',0,'기타 알려주실 분','내용','2024-01-01 00:00:00','music',10000,'한국',0);
insert into buying values('buyingId_008','test_2','닉네임2','introduction',0,'같이 공찰 사람','내용','2024-01-02 00:00:00','sports',20000,'한국',0);
insert into buying values('buyingId_009','test_3','닉네임2','introduction',0,'롤 듀오 구함니다','내용','2024-01-03 00:00:00','game',5000,'한국',0);

-- selling 내용 추가
insert into selling values('sellingId_001','qwer','닉네임1','introduction',0,'기타 알려드림니다','내용','2024-01-01 00:00:00','music',10000,'한국',0);
insert into selling values('sellingId_002','qwer','닉네임1','introduction',0,'k리그 출신 축구강의','내용','2024-01-02 00:00:00','sports',20000,'한국',0);
insert into selling values('sellingId_003','asdf','닉네임2','introduction',0,'롤 제자 구합니다','내용','2024-01-03 00:00:00','game',5000,'한국',0);
insert into selling values('sellingId_004','zxcv','닉네임2','introduction',0,'롤 제자 구합니다','내용','2024-01-03 00:00:00','game',5000,'한국',0);
insert into selling values('sellingId_005','1234','닉네임2','introduction',0,'롤 제자 구합니다','내용','2024-01-03 00:00:00','game',5000,'한국',0);
insert into selling values('sellingId_006','5678','닉네임2','introduction',0,'롤 제자 구합니다','내용','2024-01-03 00:00:00','game',5000,'한국',0);
insert into selling values('sellingId_007','test_1','닉네임2','introduction',0,'롤 제자 구합니다','내용','2024-01-03 00:00:00','game',5000,'한국',0);
insert into selling values('sellingId_008','test_2','닉네임2','introduction',0,'롤 제자 구합니다','내용','2024-01-03 00:00:00','game',5000,'한국',0);
insert into selling values('sellingId_009','test_3','닉네임2','introduction',0,'롤 제자 구합니다','내용','2024-01-03 00:00:00','game',5000,'한국',0);

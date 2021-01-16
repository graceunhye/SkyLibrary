-- 데이터베이스 생성 및 사용 선언
create database skylibrary;
use skylibrary;

-- 회원정보
create table user
(
	userID    	    varchar(20)	           comment '회원 아이디' ,  
	userPW 		    varchar(200) not null  comment '비밀번호',
	userName        varchar(20)  not null  comment '이름',
	userNum			varchar(15)             comment '전화번호',
	userPostNum     int 		           comment '우편번호', 
	userAddr        varchar(100)           comment '주소',
	userAddrDetail  varchar(100)           comment '상세주소',
	userEmail       varchar(20)            comment '이메일아이디',
	userEmailDomain varchar(100)           comment '이메일도메인', 
	primary key (userID)
);

-- 사서정보
create table manager
(
	managerID           varchar(20)    comment '사서아이디',
	managerPW           varchar(200)   comment '비밀번호',
	managerName         varchar(20)    comment '이름',
	managerEmail        varchar(20)    comment '이메일아이디',
	managerEmailDomain  varchar(100)   comment '이메일도메인', 
	primary key (managerID)
);


-- 질문 테이블 
create table q
(
	questionNo     int auto_increment       comment '글번호',
	userID         varchar(20)              comment '회원아이디',
	questionTitle  varchar(100)             comment '제목',
	questionBody   text                     comment '내용',
	questionOkDate timestamp                comment '답변일',
	questionDate   timestamp default now()  comment '작성일',
	questionHit    int   default 0          comment '조회수',
	questionType   int   default 0          comment '답변여부',
	primary key (questionNo),
	foreign key (userID) references user(userID)
);

-- 답변 테이블 
create table a
(
	questionNo   int                         comment '글번호',
	managerID    varchar(20)                 comment '사서아이디',
	answerTitle  varchar(100)                comment '제목',
	answerBody   text  		                 comment '내용',
	answerDate   timestamp default now()     comment '작성일',
	foreign key (questionNo)  references q(questionNo),
	foreign key (managerID) references manager(managerID)
);

-- 공지사항 테이블 
create table notice
(
	noticeNo     int auto_increment       comment '글번호',
	managerID    varchar(20)   	          comment '사서아이디',
	noticeTitle  varchar(100)  	          comment '제목',
	noticeBody   text          	          comment '내용',
	noticeDate   timestamp 	default now() comment '작성일',
	noticeHit    int default 0            comment '조회수',
	noticeFile   varchar(255)  	          comment '첨부파일',
	primary key (noticeNo),
	foreign key (managerID) references manager(managerID)
);

-- 도서정보
create table book
(
	bookISBN            bigint         comment 'ISBN',
	bookSubject         varchar(100)   comment '제목',
	bookStory           text           comment '줄거리', 
	bookCount           int default 0  comment '대출횟수',
	bookCompany         varchar(50)    comment '출판사',
	bookWriter          varchar(100)   comment '작가',
	bookPublicationDate timestamp      comment '발행일',
	bookRent            int default 0  comment '대여구분',
	bookCoverImg        varchar(255)   comment '커버이미지', 
	primary key (bookISBN)
);

-- 사서추천도서정보 (recommend book)
create table rbook
(
	recommendNo    int  auto_increment comment '추천도서번호',
	bookISBN       bigint     	       comment 'ISBN',
	managerID      varchar(20) 	       comment '사서아이디',
	recommendWhy   text                comment '추천이유',
	primary key (recommendNo),
	foreign key (bookISBN) references book (bookISBN),
	foreign key (managerID)  references manager (managerID) 
);


-- 신청도서정보 (apply book)
create table abook
(
	applyNo     	     int auto_increment       comment '신청번호', 
	userID    	         varchar(20)	          comment '회원 아이디',  
	applyISBN            bigint     		      comment 'ISBN',
	applySubject         varchar(100)     	      comment '제목',
	applyCompany	     varchar(50)      	      comment '출판사',
	applyPublicationDate varchar(20) 		      comment '발행일', 
	applyDate            timestamp default now()  comment '신청일',
	applyOkDate          timestamp                comment '처리일',
	applyWriter          varchar(100)			  comment '작가', 
	applyPrice           varchar(20)              comment '가격',
	applyWhy             text 				      comment '이유', 	
	applyType	         int default 0	          comment '처리구분',
	primary key (applyNo),
	foreign key (userID) references user(userID)
	
);

-- 대여도서정보
create table rent
(
	rentNo        int  auto_increment     comment '대여번호',
	userID    	  varchar(20)	 		  comment '회원 아이디',
	bookISBN      bigint			      comment 'ISBN',
	rentStartDate timestamp default now() comment '대여시작일',
	rentEndDate	  timestamp               comment '반납예정일',	
	primary key (rentNo),
	foreign key (userID)   references user(userID),
	foreign key (bookISBN) references book(bookISBN)
);
 
*** bookISBN getParameter() 할땐 스트링으로 받고,
mapper로 보낼땐 형변환을 해서 보내는 형식으로 하면 좋을 것 같다. -오혜민쌤-


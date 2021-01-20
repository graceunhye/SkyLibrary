insert into user
(
	userID,
	userPW, 
	userName, 
	userNum, 
	userPostNum, 
	userAddr, 
	userAddrDetail, 
	userEmail, 
	userEmailDomain
) value
(
	'testUser', 
	md5('test'),
	'SkyLibrary',
	'010-1111-1111',
	12345,
	'전라북도 전주시 덕진구',
	'이젠IT컴퓨터학원',
	'skylibrary',
	'ezen.ac.kr'
);

insert into manager
(
	managerID,
	managerPW,
	managerName,
	managerEmail,
	managerEmailDomain
) value
(
	'testManager',
	md5('test'),
	'EZEN',
	'ezen',
	'ezen.ac.kr'
);

insert into notice
(
	managerID,
	noticeTitle,
	noticeBody
) values
('testManager', 'noticeTest 11', 'notice body 11'),
('testManager', 'noticeTest 12', 'notice body 12'),
('testManager', 'noticeTest 13', 'notice body 13'),
('testManager', 'noticeTest 14', 'notice body 14'),
('testManager', 'noticeTest 15', 'notice body 15'),
('testManager', 'noticeTest 16', 'notice body 16'),
('testManager', 'noticeTest 17', 'notice body 17'),
('testManager', 'noticeTest 18', 'notice body 18'),
('testManager', 'noticeTest 19', 'notice body 19'),
('testManager', 'noticeTest 20', 'notice body 20');


insert into abook
(
 userID
 ,applyISBN
 ,applySubject
 ,applyCompany
 ,applyPublicationDate
 ,applyWriter
 ,applyPrice
 ,applyWhy
)
values
('testUser','123456789101','책 제목 subject 1','출판사 company 1', '2021','송은혜', '15000','도서관에 없습니다.'),
('testUser','123456789101','책 제목 subject 2','출판사 company 2', '2021','송은혜', '15000','도서관에 없습니다.'),
('testUser','123456789101','책 제목 subject 3','출판사 company 3', '2021','송은혜', '15000','도서관에 없습니다.'),
('testUser','123456789101','책 제목 subject 4','출판사 company 4', '2021','송은혜', '15000','도서관에 없습니다.'),
('testUser','123456789101','책 제목 subject 5','출판사 company 5', '2021','송은혜', '15000','도서관에 없습니다.'),
('testUser','123456789101','책 제목 subject 6','출판사 company 6', '2021','송은혜', '15000','도서관에 없습니다.'),
('testUser','123456789101','책 제목 subject 7','출판사 company 7', '2021','송은혜', '15000','도서관에 없습니다.'),
('testUser','123456789101','책 제목 subject 8','출판사 company 8', '2021','송은혜', '15000','도서관에 없습니다.'),
('testUser','123456789101','책 제목 subject 9','출판사 company 9', '2021','송은혜', '15000','도서관에 없습니다.'),
('testUser','123456789101','책 제목 subject 10','출판사 company 10', '2021','송은혜', '15000','도서관에 없습니다.'),
('testUser','123456789101','책 제목 subject 11','출판사 company 11', '2021','송은혜', '15000','도서관에 없습니다.');


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




RENAME TABLE channel TO book;

ALTER TABLE book CHANGE COLUMN title bookSubject varchar(100) comment '책제목';
ALTER TABLE book CHANGE COLUMN publisher bookCompany varchar(50) comment '출판사';
ALTER TABLE book CHANGE COLUMN coversmallurl bookCoverImg varchar(255) comment '커버이미지';
ALTER TABLE book CHANGE COLUMN description bookStory text comment '줄거리';
ALTER TABLE book CHANGE COLUMN isbn bookISBN bigint; comment 'isbn';
ALTER TABLE book CHANGE COLUMN author bookWriter varchar(100) comment '작가명';
ALTER TABLE book CHANGE COLUMN pubdate bookPublicationDate datetime comment '발행일';

ALTER TABLE book ADD COLUMN bookRent int default 0 comment '대여구분';
ALTER TABLE book ADD COLUMN bookCount int default 0  comment '대출횟수';
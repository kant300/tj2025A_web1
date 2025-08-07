drop database if exists 실습4;
create database 실습4;
use 실습4;

create table waiting(
	wno int auto_increment , 
	phone varchar(13) not null ,
    count int not null ,
    wdate datetime default now(),
    constraint primary key(wno)
);

# 샘플 
INSERT INTO waiting (phone, count) VALUES ('010-1111-2222', 2);
INSERT INTO waiting (phone, count) VALUES ('010-3333-4444', 3);
INSERT INTO waiting (phone, count) VALUES ('010-5555-6666', 1);
INSERT INTO waiting (phone, count) VALUES ('010-7777-8888', 5);
INSERT INTO waiting (phone, count) VALUES ('010-9999-0000', 2);
INSERT INTO waiting (phone, count) VALUES ('010-1234-5678', 4);
INSERT INTO waiting (phone, count) VALUES ('010-8765-4321', 1);
INSERT INTO waiting (phone, count) VALUES ('010-2468-1357', 3);
INSERT INTO waiting (phone, count) VALUES ('010-1357-2468', 2);
INSERT INTO waiting (phone, count) VALUES ('010-9876-5432', 6);
INSERT INTO waiting (phone, count) VALUES ('010-0101-2020', 1);
INSERT INTO waiting (phone, count) VALUES ('010-2020-0101', 3);
INSERT INTO waiting (phone, count) VALUES ('010-1122-3344', 2);
INSERT INTO waiting (phone, count) VALUES ('010-5566-7788', 4);
INSERT INTO waiting (phone, count) VALUES ('010-9900-1122', 1);
INSERT INTO waiting (phone, count) VALUES ('010-3456-7890', 5);
INSERT INTO waiting (phone, count) VALUES ('010-6789-0123', 2);
INSERT INTO waiting (phone, count) VALUES ('010-0000-1111', 3);
INSERT INTO waiting (phone, count) VALUES ('010-2222-3333', 1);
INSERT INTO waiting (phone, count) VALUES ('010-4444-5555', 4);

select * from waiting;
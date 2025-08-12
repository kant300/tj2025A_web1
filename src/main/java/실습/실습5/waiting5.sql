drop database if exists 실습5;
create database 실습5;
use 실습5;

create table waiting(
	wno int auto_increment , 
	phone varchar(13) not null ,
    count int not null ,
    date datetime default now(),
    constraint primary key(wno)
);

# 샘플 
INSERT INTO waiting (phone, count, date) VALUES ('010-1111-2222', 2, '2025-07-28');
INSERT INTO waiting (phone, count, date) VALUES ('010-3333-4444', 3, '2025-07-28');
INSERT INTO waiting (phone, count, date) VALUES ('010-5555-6666', 1, '2025-07-29');
INSERT INTO waiting (phone, count, date) VALUES ('010-7777-8888', 4, '2025-07-29');
INSERT INTO waiting (phone, count, date) VALUES ('010-9999-0000', 2, '2025-07-30');
INSERT INTO waiting (phone, count, date) VALUES ('010-1234-5678', 5, '2025-07-30');
INSERT INTO waiting (phone, count, date) VALUES ('010-8765-4321', 1, '2025-07-31');
INSERT INTO waiting (phone, count, date) VALUES ('010-2468-1357', 3, '2025-07-31');
INSERT INTO waiting (phone, count, date) VALUES ('010-1357-2468', 2, '2025-08-01');
INSERT INTO waiting (phone, count, date) VALUES ('010-9876-5432', 4, '2025-08-01');
INSERT INTO waiting (phone, count, date) VALUES ('010-1122-3344', 1, '2025-08-02');
INSERT INTO waiting (phone, count, date) VALUES ('010-2233-4455', 3, '2025-08-02');
INSERT INTO waiting (phone, count, date) VALUES ('010-3344-5566', 2, '2025-08-03');
INSERT INTO waiting (phone, count, date) VALUES ('010-4455-6677', 5, '2025-08-03');
INSERT INTO waiting (phone, count, date) VALUES ('010-5566-7788', 4, '2025-08-04');
INSERT INTO waiting (phone, count, date) VALUES ('010-6677-8899', 1, '2025-08-04');
INSERT INTO waiting (phone, count, date) VALUES ('010-7788-9900', 3, '2025-08-05');
INSERT INTO waiting (phone, count, date) VALUES ('010-8899-0011', 2, '2025-08-05');
INSERT INTO waiting (phone, count, date) VALUES ('010-9900-1122', 4, '2025-08-06');
INSERT INTO waiting (phone, count, date) VALUES ('010-0011-2233', 1, '2025-08-06');

select * from waiting;
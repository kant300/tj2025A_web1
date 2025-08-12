drop database if exists assessment;
create database assessment;
use assessment;

CREATE TABLE member(
	custno INT NOT NULL AUTO_INCREMENT, -- 회원번호
    custname VARCHAR(20),               -- 회원성명
    phone VARCHAR(13),                  -- 연락처(하이픈포함)
    address VARCHAR(60),                -- 주소
    joindate DATE ,        				-- 가입일자(YYYY-MM-DD)
    grade CHAR(1),                      -- 고객등급(A/B/C)
    city CHAR(2),                       -- 거주도시코드
    CONSTRAINT PRIMARY KEY (custno)     -- 기본 키 설정 
);

# 회원정보샘플
insert into member(custno, custname, phone, address, joindate, grade , city)
values(100001 ,"김행복", '010-1111-2222', "서울 동대문구 휘경1동", '2015-12-02', "A", '01');
insert into member(custname, phone, address, joindate, grade , city)
values("이축복", '010-1111-3333', "서울 동대문구 휘경2동", '2015-12-06', "B", '01');
insert into member(custname, phone, address, joindate, grade , city)
values("장믿음", '010-1111-4444', "울릉군 울릉읍 독도1리", '2015-10-01', "B", '30');
insert into member(custname, phone, address, joindate, grade , city)
values("최사랑", '010-1111-5555', "울릉군 울릉읍 독도2리", '2015-11-13', "A", '30');
insert into member(custname, phone, address, joindate, grade , city)
values("진평화", '010-1111-6666', "제주도 제주시 외나무골", '2015-12-25', "B", '60');
insert into member(custname, phone, address, joindate, grade , city)
values("자공단", '010-1111-7777', "제주도 제주시 감나무골", '2015-12-11', "C", '60');
				

select * from member;

create table money(
custno int not null, -- 회원번호 fk
salenol int not null, -- 판매번호 pk
pcost int, 		-- 단가
amount	int, 	-- 수량
price int,		-- 가격(금액)
pcode varchar(4),	-- 상품코드
sdate date,		-- 판매일자
constraint primary key(salenol),
constraint foreign key(custno) references member(custno)
);

# 회원매출 샘플
insert into money(custno, salenol, pcost, amount, price, pcode, sdate) 
value(100001, 20160001, 500, 5, 2500, "A001", '2016-01-01');
insert into money(custno, salenol, pcost, amount, price, pcode, sdate) 
value(100001, 20160002, 1000, 4, 4000, "A002", '2016-01-01');
insert into money(custno, salenol, pcost, amount, price, pcode, sdate) 
value(100001, 20160003, 500, 3, 1500, "A008", '2016-01-01');
insert into money(custno, salenol, pcost, amount, price, pcode, sdate) 
value(100002, 20160005, 500, 1, 500, "A001", '2016-01-03');
insert into money(custno, salenol, pcost, amount, price, pcode, sdate) 
value(100003, 20160006, 1500, 2, 3000, "A003", '2016-01-03');
insert into money(custno, salenol, pcost, amount, price, pcode, sdate) 
value(100004, 20160007, 500, 2, 1000, "A001", '2016-01-04');
insert into money(custno, salenol, pcost, amount, price, pcode, sdate) 
value(100004, 20160008, 300, 1, 300, "A005", '2016-01-04');
insert into money(custno, salenol, pcost, amount, price, pcode, sdate) 
value(100004, 20160009, 600, 1, 600, "A006", '2016-01-04');
insert into money(custno, salenol, pcost, amount, price, pcode, sdate) 
value(100004, 20160010, 3000, 1, 3000, "A007", '2016-01-06');

select * from money;
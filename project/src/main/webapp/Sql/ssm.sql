create database ssm;

use ssm;

create table members(
mb_code varchar (6) primary key,
id varchar (20)  not null unique key,
password varchar (20) not null,
name varchar (40) not null,
contact varchar (20) unique key,
email varchar (40),
gender int (2),
address varchar (40),
birth datetime,
enroll_date datetime
);
drop table members;
select * from members;
insert into members value('mb3852', 'apple','2345','사과', '01012345678', '123a@asd.com',1,'asdhekjhkjjbsd;',"2022-01-01","2022-07-10");

create table items(
	item_code varchar(5) primary key,
	cate_name varchar(100) not null, -- fk
	item_name varchar(20) not null,
	item_price int(20) not null,
	image varchar(200),
	des varchar(1000),
	enroll datetime not null,
	foreign key(cate_name) references item_category(cate_name)
);
drop table items;
select * from items;

insert into items value('1001',	'm_Top_longSleeves',	'남성긴팔',		25000,'https://images.unsplash.com/photo-1617724016712-532874fcf251?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80','따뜻하고 운동하기 편한 긴팔입니다','2020-10-08');
insert into items value('1002',	'm_Top_longSleeves',	'남성긴팔',		37000,'https://images.unsplash.com/photo-1598632598200-beb70561625f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=700&q=80','신축성이 좋은 긴팔입니다','2021-03-05');
insert into items value('1003',	'm_Top_shortSleeves',	'남성반팔',		20000,'https://cdn.pixabay.com/photo/2016/12/06/09/30/blank-1886001_960_720.png','시원한 반팔 입니다','2022-06-13');
insert into items value('1004',	'm_Top_shortSleeves',	'남성반팔',		17000,'https://images.unsplash.com/photo-1571455786673-9d9d6c194f90?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80','시원하고 신축성이 좋은 반팔입니다','2022-07-07');
insert into items value('1005',	'm_Top_sweatShirt',		'남성스웨트셔츠',	33000,'https://images.unsplash.com/photo-1556821840-3a63f95609a7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80','따뜻하고 겨울에 운동하기 좋은 긴팔입니다','2022-07-07');
insert into items value('1006',	'm_Top_sweatShirt',		'남성스웨트셔츠',	55000,'https://images.unsplash.com/photo-1614975059251-992f11792b9f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80','보라색 스웨트셔츠 입니다','2022-07-07');
insert into items value('1007',	'm_Bottoms_longPants',	'남성긴바지',		27000,'https://images.unsplash.com/photo-1518738458435-19149697112a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=688&q=80','따뜻한 검은색 긴바지 입니다','2022-03-07');
insert into items value('1008',	'm_Bottoms_longPants',	'남성긴바지',		30000,'https://images.unsplash.com/photo-1506638794690-bbea5c6f0ab7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80','하얀색 긴바지 입니다','2019-05-07');
insert into items value('1009',	'm_Bottoms_shortPants',	'남성반바지',		20000,'https://images.unsplash.com/photo-1525914813433-886dc018469d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80','운동에 편한 반바지','2022-05-15');
insert into items value('1010',	'm_Bottoms_shortPants',	'남성반바지',		15000,'https://images.unsplash.com/photo-1591741543032-bf439b4fd46c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80','이쁜 파란색 반바지 입니다','2022-05-15');
insert into items value('1011',	'm_Bottoms_leggings',	'남성레깅스',		25000,'https://w7.pngwing.com/pngs/513/102/png-transparent-robot-leg-human-leg-class-web-browser-legs-miscellaneous-people-actionscript-thumbnail.png','최신 디자인 레깅스 입니다','2021-02-05');
insert into items value('1012',	'm_Bottoms_leggings',	'남성레깅스',		35000,'https://w7.pngwing.com/pngs/513/102/png-transparent-robot-leg-human-leg-class-web-browser-legs-miscellaneous-people-actionscript-thumbnail.png','고품질 레깅스 입니다','2020-01-05');
insert into items value('1013',	'f_Top_longSleeves',	'여성긴팔',		25000,'https://w7.pngwing.com/pngs/832/802/png-transparent-long-sleeved-t-shirt-long-sleeved-t-shirt-clothing-sportswear-women-volleyball-purple-tshirt-white-thumbnail.png','형광색 이쁜 긴팔 입니다','2019-03-27');
insert into items value('1014',	'f_Top_longSleeves',	'여성긴팔',		30000,'https://w7.pngwing.com/pngs/655/630/png-transparent-sleeve-t-shirt-pink-clothing-pink-baby-long-sleeved-clothes-tshirt-white-baby-thumbnail.png','알록달록한 색깔의 긴팔 입니다','2022-03-26');
insert into items value('1015',	'f_Top_shortSleeves',	'여성반팔',		17000,'https://w7.pngwing.com/pngs/366/565/png-transparent-t-shirt-polo-shirt-shoe-collar-polo-shirt-tshirt-angle-white-thumbnail.png','스트리커 반팔 티셔츠 입니다','2019-06-06');
insert into items value('1016',	'f_Top_shortSleeves',	'여성반팔',		20000,'https://w7.pngwing.com/pngs/241/495/png-transparent-t-shirt-blouse-dress-women-s-clothing-s-tshirt-white-pin-thumbnail.png','신축성이 좋은 연한 빨강색 반팔 입니다','2021-12-25');
insert into items value('1017',	'f_Top_sweatShirt',		'여성스웨트셔츠',	65000,'https://w7.pngwing.com/pngs/575/292/png-transparent-hoodie-jacket-drawing-coat-sweater-jacket-blue-hoodie-cartoon-thumbnail.png','색상이 아름다운 후드입니다.','2022-06-08');
insert into items value('1018',	'f_Top_sweatShirt',		'여성스웨트셔츠',	50000,'https://w7.pngwing.com/pngs/620/167/png-transparent-red-pullover-hoodie-ilustration-red-hoodie-sweater-clothing-men-s-sweater-jacket-men-suit-fictional-character-top-thumbnail.png','기본 하얀색에 작은 로고가 있는 스웨트셔츠입니다','2022-02-28');
insert into items value('1019',	'f_Bottoms_longPants',	'여성긴바지',		35000,'https://images.unsplash.com/photo-1650461970708-7bf32499516d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=627&q=80','회색의 따뜻한 긴바지 입니다','2022-07-10');
insert into items value('1020',	'f_Bottoms_longPants',	'여성긴바지',		25000,'https://images.unsplash.com/photo-1589413364939-9f9fedb13e20?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80','고품질 긴바지 입니다','2022-07-10');
insert into items value('1021',	'f_Bottoms_shortPants',	'여성반바지',		10000,'https://w7.pngwing.com/pngs/930/774/png-transparent-shorts-sport-clothing-baseball-white-sport-trunks-thumbnail.png','빨간색 반바지 입니다','2022-01-01');
insert into items value('1022',	'f_Bottoms_shortPants',	'여성반바지',		15000,'https://w7.pngwing.com/pngs/922/133/png-transparent-shorts-beach-pants-beach-beach-cartoon-swimsuit-bottom-thumbnail.png','최신 디자인의 반바지 입니다','2022-01-01');
insert into items value('1023',	'f_Bottoms_leggings',	'여성레깅스',		25000,'https://w7.pngwing.com/pngs/883/915/png-transparent-leggings-tights-clothing-pants-white-gym-girl-white-physical-fitness-sport-thumbnail.png','튼튼한 레깅스 입니다','2018-03-25');
insert into items value('1024',	'f_Bottoms_leggings',	'여성레깅스',		35000,'https://w7.pngwing.com/pngs/141/426/png-transparent-capri-pants-reebok-sneakers-clothing-sportswear-pant-sport-sneakers-adidas-thumbnail.png','색감이 좋은 레깅스 입니다','2022-11-30');
-- update items set image='https://w7.pngwing.com/pngs/575/292/png-transparent-hoodie-jacket-drawing-coat-sweater-jacket-blue-hoodie-cartoon-thumbnail.png' 
-- where item_code='1017' ; 

insert into itemSizeStock (stock_code , item_code) VALUES ('1001','1001');
insert into itemSizeStock (stock_code , item_code) VALUES ('1002','1002');
insert into itemSizeStock (stock_code , item_code) VALUES ('1003','1003');
insert into itemSizeStock (stock_code , item_code) VALUES ('1004','1004');
insert into itemSizeStock (stock_code , item_code) VALUES ('1005','1005');
insert into itemSizeStock (stock_code , item_code) VALUES ('1006','1006');
insert into itemSizeStock (stock_code , item_code) VALUES ('1007','1007');
insert into itemSizeStock (stock_code , item_code) VALUES ('1008','1008');
insert into itemSizeStock (stock_code , item_code) VALUES ('1009','1009');
insert into itemSizeStock (stock_code , item_code) VALUES ('1010','1010');
insert into itemSizeStock (stock_code , item_code) VALUES ('1011','1011');
insert into itemSizeStock (stock_code , item_code) VALUES ('1012','1012');
insert into itemSizeStock (stock_code , item_code) VALUES ('1013','1013');
insert into itemSizeStock (stock_code , item_code) VALUES ('1014','1014');
insert into itemSizeStock (stock_code , item_code) VALUES ('1015','1015');
insert into itemSizeStock (stock_code , item_code) VALUES ('1016','1016');
insert into itemSizeStock (stock_code , item_code) VALUES ('1017','1017');
insert into itemSizeStock (stock_code , item_code) VALUES ('1018','1018');
insert into itemSizeStock (stock_code , item_code) VALUES ('1019','1019');
insert into itemSizeStock (stock_code , item_code) VALUES ('1020','1020');
insert into itemSizeStock (stock_code , item_code) VALUES ('1021','1021');
insert into itemSizeStock (stock_code , item_code) VALUES ('1022','1022');
insert into itemSizeStock (stock_code , item_code) VALUES ('1023','1023');
insert into itemSizeStock (stock_code , item_code) VALUES ('1024','1024');



create table item_category(
    cate_name varchar(100) primary key
);
drop table items_category;
select * from item_category;
insert into item_category value('m_Top_longSleeves');
insert into item_category value('m_Top_shortSleeves');
insert into item_category value('m_Top_sweatShirt');
insert into item_category value('m_Bottoms_longPants');
insert into item_category value('m_Bottoms_shortPants');
insert into item_category value('m_Bottoms_leggings');
insert into item_category value('f_Top_longSleeves');
insert into item_category value('f_Top_shortSleeves');
insert into item_category value('f_Top_sweatShirt');
insert into item_category value('f_Bottoms_longPants');
insert into item_category value('f_Bottoms_shortPants');
insert into item_category value('f_Bottoms_leggings');
-- insert into item_category value('m_Shoes_runningShoes');
-- insert into item_category value('m_Shoes_reainingShoes');
-- insert into item_category value('m_Shoes_basketBallShoes');
-- insert into item_category value('m_Shoes_sandals');
-- insert into item_category value('f_Shoes_runningShoes');
-- insert into item_category value('f_Shoes_trainingShoes');
-- insert into item_category value('f_Shoes_basketBallShoes');
-- insert into item_category value('f_Shoes_sandals');

-- select * from cartItemList where mb_code= ?;
create table cartItemList(
	cartItem_code varchar(5) primary key,
    mb_code varchar(6) not null, -- fk
    item_code varchar(5) not null, -- fk
	size varchar(4) not null,
    quantity varchar(5) not null,
	enroll datetime not null,
    foreign key(mb_code) references members(mb_code),
    foreign key(item_code) references items(item_code)
);
drop table cartItemList;
select * from cartItemList;

create table wishItemList(
	wishItem_code varchar(5) primary key,
	mb_code varchar(6) not null, -- fk
	item_code varchar(5) not null, -- fk
	size varchar(4) not null,
    wish_enroll datetime not null,
	foreign key(mb_code) references members(mb_code),
    foreign key(item_code) references items(item_code)
);
drop table wishItemList;
select * from wishItemList;

create table order_List(
	order_code varchar(5) primary key,
	mb_code varchar(6) not null, -- fk
	order_date datetime not null,
	order_name varchar (30) not null,
	order_add varchar (50) not null,
	order_contact varchar(20) not null,
    foreign key (mb_code) references members(mb_code)
);
drop table orderList;
select * from cart;

create table orderItemList(
	orderItem_Code varchar(5) primary key,
	order_code varchar(5) not null, -- fk
	item_code varchar(5) not null, -- fk
	count int (5) not null,
    foreign key (order_code) references order_List(order_code),
    foreign key (item_code) references items(item_code)
);
drop table orderItemList;
select * from orderItemList;

create table board(
	b_code varchar(5) primary key,
	mb_code varchar(6) not null , -- fk
    title varchar(50) not null,
    contents varchar(2000) not null,
    viewCnt int (4) default 0,
    createdAt Timestamp,
    modifiedAt  Timestamp,
    foreign key (mb_code) references members(mb_code)
);

insert into board value('1231','mb3852','test title', '테스트용 컨텐츠 작성 입니다.',0,0,'2022-07-12','2022-07-12');
drop table board;
select * from board;

create table itemSizeStock(
	stock_code varchar(5) primary key,
	item_code varchar(5) NOT NULL,
	XS int(4) default 20,
	S int(4) default 20,
	M int(4) default 20,
	L int(4) default 20,
	XL int(4) default 20,
	XXL int(4) default 20,
	foreign key(item_code) references items(item_code)
);

drop database ssm;
show tables;
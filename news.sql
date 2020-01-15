create database news_java;

use news_java;

create table admin_(
	username varchar(20) not null,
    name_ varchar(35),
    address varchar(20),
    email varchar(25),
    password_ varchar(20),
    constraint user_pk primary key (username)
    );
    
create table news(
	hash_ varchar(200) not null,
    descr TEXT,
    sport varchar(15),
    team_code varchar(5),
    image TEXT,
    league varchar(20),
    team varchar(30),
    link TEXT,
    published_at varchar(50),
    username varchar(20) not null,
	constraint admin_pk primary key (hash_),
    constraint news_to_admin foreign key(username) references admin_(username)
);

insert into admin_ (username,name_,address,email,password_) values ('bedircaushi','Bedir Caushi','Tetovo','bedir@gmail.com','bedir123');
insert into admin_ (username,name_,address,email,password_) values ('jasirfetai','Jasir Fetai','Gostivar','jasir@gmail.com','jasir123');
insert into admin_ (username,name_,address,email,password_) values ('rondemiri','Ron Demiri','Tetovo','ron@gmail.com','ron123');

insert into news (hash_,descr,sport,team_code,image,league,team,link,published_at,username,title) values ('ajasd5asd565as5dfd','real madrid won uefa champions league','football','RMA','image','ucl','RealMadrid','link','1/15/2019','bedircaushi','rma ucl');
insert into news (hash_,descr,sport,team_code,image,league,team,link,published_at,username,title) values ('ajasd5asdhq5dfd','liverpool lost champions league','football','LIV','image2','ucl','Liverpool','link','1/15/2019','rondemiri','liverpool ucl');
insert into news (hash_,descr,sport,team_code,image,league,team,link,published_at,username,title) values ('aassd5asdhq5dfd','NBA has started','basketball','BOC','image3','NBA','Boston','link','1/15/2019','jasirfetai','nba start');

select * from admin_;

select * from news;

SELECT COUNT(*) 
FROM news;

ALTER TABLE news
MODIFY team_code varchar(50);

select distinct sport from news ;

alter table news add column title varchar(500);

alter table news drop column hash_;
alter table news add column id integer not null primary key auto_increment;
alter table news add column hash_ varchar(300) not null unique;
alter table admin_ modify password_ varchar(300);

SELECT * FROM news;

DELETE FROM admin_ WHERE username="testUsername";
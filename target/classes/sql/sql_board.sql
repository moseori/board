drop table if exists board_tbl;

create table board_tbl(
bno int auto_increment primary key,
title varchar(300) not null,
contents text not null,
writer varchar(50) not null,
regDate timeStamp default current_timestamp,
updateDate timeStamp default current_timestamp
);

insert into board_tbl(title,contents,writer) 
values('게시물 제목입니다','내용 테스트입니다.','테스트');
insert into board_tbl(title,contents,writer) 
values('게시물 제목입니다2','내용 테스트입니다.2','테스트2');
insert into board_tbl(title,contents,writer) 
values('게시물 제목입니다3','내용 테스트입니다.3','테스트3');
insert into board_tbl(title,contents,writer) 
values('게시물 제목입니다4','내용 테스트입니다.4','테스트4');
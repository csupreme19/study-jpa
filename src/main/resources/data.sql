INSERT INTO ACCOUNT(id, password, username, last_password_modified_at, created_at, created_ip, modified_at, modified_ip)
VALUES ('csupreme19', '!new1234', 'seunghoon.choi', current_timestamp(), current_timestamp(), '127.0.0.1', current_timestamp(), '127.0.0.1');
INSERT INTO PERSON(account_id, age, phone, email, created_at, created_ip, modified_at, modified_ip)
VALUES ('csupreme19', '29', '01098887886', 'csupreme19@gmail.com', current_timestamp(), '127.0.0.1', current_timestamp(), '127.0.0.1');

INSERT INTO ACCOUNT(id, password, username, last_password_modified_at, created_at, created_ip, modified_at, modified_ip)
VALUES ('honggildong19', '!new1234', 'gildong.hong', current_timestamp(), current_timestamp(), '127.0.0.2', current_timestamp(), '127.0.0.2');
INSERT INTO PERSON(account_id, age, phone, email, created_at, created_ip, modified_at, modified_ip)
VALUES ('honggildong19', '28', '01098887886', 'honggildong19@gmail.com', current_timestamp(), '127.0.0.2', current_timestamp(), '127.0.0.2');

INSERT INTO ACCOUNT(id, password, username, last_password_modified_at, created_at, created_ip, modified_at, modified_ip)
VALUES ('honggilsoon19', '!new1234', 'gilsoon.hong', current_timestamp(), current_timestamp(), '127.0.0.3', current_timestamp(), '127.0.0.3');
INSERT INTO PERSON(account_id, age, phone, email, created_at, created_ip, modified_at, modified_ip)
VALUES ('honggilsoon19', '27', '01098887886', 'honggilsoon@gmail.com', current_timestamp(), '127.0.0.3', current_timestamp(), '127.0.0.3');

INSERT INTO CATEGORY(category_name, created_at, created_ip, modified_at, modified_ip)
VALUES ('커뮤니티', current_timestamp(), '127.0.0.3', current_timestamp(), '127.0.0.3');

INSERT INTO CATEGORY(category_name, parent_id, created_at, created_ip, modified_at, modified_ip)
VALUES ('자유게시판', 1, current_timestamp(), '127.0.0.3', current_timestamp(), '127.0.0.3');

INSERT INTO POST(category_id, title, content, view_count, created_at, created_id, created_ip, modified_at, modified_id, modified_ip)
VALUES ('1', '첫 게시물', '게시물 내용', 0, current_timestamp(), 'honggilsoon19', '127.0.0.3', current_timestamp(), 'honggilsoon19', '127.0.0.3');
INSERT INTO POST(category_id, title, content, view_count, created_at, created_id, created_ip, modified_at, modified_id, modified_ip)
VALUES ('1', '안녕하세용', '안녕2하세요', 0, current_timestamp(), 'honggildong19', '127.0.0.3', current_timestamp(), 'honggildong19', '127.0.0.3');
INSERT INTO POST(category_id, title, content, view_count, created_at, created_id, created_ip, modified_at, modified_id, modified_ip)
VALUES ('1', '안녕난', '안녕3하세요', 0, current_timestamp(), 'csupreme19', '127.0.0.3', current_timestamp(), 'csupreme19', '127.0.0.3');

INSERT INTO TAG(tag_name, created_at, created_ip, modified_at, modified_ip)
VALUES ('개발', current_timestamp(), '127.0.0.3', current_timestamp(), '127.0.0.3');
INSERT INTO TAG(tag_name, created_at, created_ip, modified_at, modified_ip)
VALUES ('소통', current_timestamp(), '127.0.0.3', current_timestamp(), '127.0.0.3');
INSERT INTO TAG(tag_name, created_at, created_ip, modified_at, modified_ip)
VALUES ('백엔드', current_timestamp(), '127.0.0.3', current_timestamp(), '127.0.0.3');
INSERT INTO TAG(tag_name, created_at, created_ip, modified_at, modified_ip)
VALUES ('프론트엔드', current_timestamp(), '127.0.0.3', current_timestamp(), '127.0.0.3');

INSERT INTO POST_TAG(post_id, tag_id) VALUES (1, 1);
INSERT INTO POST_TAG(post_id, tag_id) VALUES (1, 2);
INSERT INTO POST_TAG(post_id, tag_id) VALUES (1, 3);
INSERT INTO POST_TAG(post_id, tag_id) VALUES (2, 1);
INSERT INTO POST_TAG(post_id, tag_id) VALUES (2, 3);
INSERT INTO POST_TAG(post_id, tag_id) VALUES (3, 2);

INSERT INTO ITEM(item_name, item_number, item_price, enabled, created_at, created_ip, modified_at, modified_ip)
VALUES ('키보드', '123-342', 150000, true, current_timestamp(), '127.0.0.1', current_timestamp(), '127.0.0.1');
INSERT INTO ITEM(item_name, item_number, item_price, enabled, created_at, created_ip, modified_at, modified_ip)
VALUES ('마우스', '535-589', 30000, true, current_timestamp(), '127.0.0.2', current_timestamp(), '127.0.0.1');
INSERT INTO ITEM(item_name, item_number, item_price, enabled, created_at, created_ip, modified_at, modified_ip)
VALUES ('받침대', '732-741', 20000, false, current_timestamp(), '127.0.0.1', current_timestamp(), '127.0.0.2');
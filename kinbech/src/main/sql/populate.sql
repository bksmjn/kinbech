 
INSERT INTO credentials(username,password,is_active) VALUES ('admin','pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=',TRUE);

#comment table
insert into comment (commentid,productid) values (1,1);
insert into comment (commentid,productid) values (2,2);
insert into comment (commentid,productid) values (3,3);

insert into post (postid,postmessage,username) values (1,'message from user :one','one');
insert into post (postid,postmessage,username) values (2,'message from user :two','two');
insert into post (postid,postmessage,username) values (3,'message from user :three','three');	

insert into post (postid,postmessage,username) values (4,'message from user :four','four');	

insert into post (postid,postmessage,username) values (5,'message from user :five','five');
insert into post (postid,postmessage,username) values (6,'message from user :six','six');
insert into post (postid,postmessage,username) values (7,'message from user :seven','seven');

insert into comment_post (comment_commentid,posts_postid) values (1,1);
insert into comment_post (comment_commentid,posts_postid) values (1,2);
insert into comment_post (comment_commentid,posts_postid) values (1,3);

insert into comment_post (comment_commentid,posts_postid) values (2,4);

insert into comment_post (comment_commentid,posts_postid) values (3,5);
insert into comment_post (comment_commentid,posts_postid) values (3,6);
insert into comment_post (comment_commentid,posts_postid) values (3,7);

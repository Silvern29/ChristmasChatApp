-- Insert role
insert into role (name) values ('ROLE_USER');

-- Insert two users (passwords are both 'password')
insert into user (user_name,email,password,role_id,enabled) values ('user','user@user.com','1234',1,true);
insert into user (user_name,email,password,role_id,enabled) values ('user2','user2@user2.com','1234',1,true);

-- Insert message
insert into message (user_id,msg_content) values (1,'Code Task entity');
insert into message (user_id,msg_content) values (2,'Discuss users and roles');
insert into message (user_id,msg_content) values (1,'Enable Spring Security');
insert into message (user_id,msg_content) values (2,'Test application');
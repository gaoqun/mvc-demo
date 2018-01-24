CREATE TABLE health_dev.w_user
(
    open_id int(11) PRIMARY KEY NOT NULL COMMENT '微信openId',
    union_id varchar(45) NOT NULL COMMENT 'unionId',
    money decimal(5,2) NOT NULL,
    username varchar(45) NOT NULL
);
INSERT INTO health_dev.w_user (open_id, union_id, money, username) VALUES (1, '10001', 888.88, '高群');
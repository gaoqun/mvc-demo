CREATE TABLE health_dev.h_user_info
(
    id int(10) unsigned PRIMARY KEY NOT NULL COMMENT '用户id' AUTO_INCREMENT,
    user_name varchar(20) NOT NULL COMMENT '用户名称',
    pwd varchar(20) NOT NULL COMMENT '用户密码',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    telephone varchar(11) NOT NULL COMMENT '手机号',
    nick_name varchar(30) COMMENT '昵称',
    money decimal(6,2) NOT NULL,
    open_id int(11),
    combine_account_flag int(11) DEFAULT '0',
    combine_account_time timestamp
);
CREATE UNIQUE INDEX id_UNIQUE ON health_dev.h_user_info (id);
CREATE UNIQUE INDEX h_user_info_open_id_uindex ON health_dev.h_user_info (open_id);
INSERT INTO health_dev.h_user_info (id, user_name, pwd, create_time, telephone, nick_name, money, open_id, combine_account_flag, combine_account_time) VALUES (1, '赫鲁晓夫', '111111', '2017-12-06 11:15:26', '17612322222', '张三子', 0.00, null, 0, null);
INSERT INTO health_dev.h_user_info (id, user_name, pwd, create_time, telephone, nick_name, money, open_id, combine_account_flag, combine_account_time) VALUES (2, '高群', '123456', '2018-01-24 16:38:43', '17600228859', 'gaige', 6222.16, 1, 1, '2018-01-24 04:38:43');
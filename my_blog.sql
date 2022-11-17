-- 由于mybatis plus使用雪花算法计算自增id，会生成很多位数的数字，所以需要使用Bigint而不是int

-- ----------------------------
-- Table structure for blog_account
-- ----------------------------
DROP TABLE IF EXISTS blog_account;
CREATE TABLE blog_account (
id BIGINT(0) NOT NULL AUTO_INCREMENT,
username VARCHAR(64) NOT NULL,
`password` VARCHAR(64) NOT NULL,
created_date DATETIME DEFAULT NULL,
PRIMARY KEY(id) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

ALTER TABLE blog_account RENAME AS blog_user;

DESC blog_user;
SELECT * FROM blog_user;

INSERT INTO blog_user 
VALUES (1,"tUser1","test111",NULL);

INSERT INTO blog_user 
VALUES (2,"admin","admin",NULL);
-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS blog_article;
CREATE TABLE blog_article (
id BIGINT(0) NOT NULL AUTO_INCREMENT,
title VARCHAR(64) NOT NULL,
summary VARCHAR(255) NOT NULL,
`content` LONGTEXT,
`created_date` DATETIME NOT NULL ON UPDATE CURRENT_TIMESTAMP,
user_id BIGINT(0) NOT NULL,
category_id BIGINT(0),
view_counts INT,
PRIMARY KEY(id) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

DESC blog_article;

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS blog_category;
CREATE TABLE blog_category (
id BIGINT(0) NOT NULL AUTO_INCREMENT,
category_name VARCHAR(32) NOT NULL,
article_id BIGINT(0) NOT NULL,
PRIMARY KEY(id) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

DESC blog_category;


INSERT INTO blog_article
VALUES (1,"Test Title1","test summary","test content",'2022-11-17 08:21:22',1,NULL,0);

INSERT INTO blog_article
VALUES (2,"Test Title2","test summary 2","test content 2",'2022-11-18 10:21:22',1,NULL,0);

SELECT * FROM blog_article;

-- 由于mybatis plus使用雪花算法计算自增id，会生成很多位数的数字，所以需要使用Bigint而不是int

-- ----------------------------
-- Table structure for blog_account
-- ----------------------------
DROP TABLE IF EXISTS blog_user;

CREATE TABLE blog_user (
id BIGINT(0) NOT NULL AUTO_INCREMENT,
username VARCHAR(64) NOT NULL,
`password` VARCHAR(64) NOT NULL,
created_date DATETIME NULL DEFAULT NULL,
PRIMARY KEY(id) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

DESC blog_user;
SELECT * FROM blog_user;

INSERT INTO blog_user 
VALUES (1,"tUser1","caae519044a1f4b34566849bcb23265e",NULL);  -- test111

-- delete from blog_user where id=1;

INSERT INTO blog_user 
VALUES (2,"admin","adeacea814ee528a953e4b6242ac1be7",NULL);  -- admin


-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS blog_article;
CREATE TABLE blog_article (
id BIGINT(0) NOT NULL AUTO_INCREMENT,
title VARCHAR(64) NULL DEFAULT NULL,
summary VARCHAR(255) NULL DEFAULT NULL,
`content` LONGTEXT NULL DEFAULT NULL,
`created_date` DATETIME NULL DEFAULT NULL,
user_id BIGINT(0) DEFAULT NULL,
category_id BIGINT(0) DEFAULT NULL,
view_counts INT DEFAULT NULL,
PRIMARY KEY(id) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

DESC blog_article;

SELECT * FROM blog_article;

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS blog_category;

CREATE TABLE blog_category (
id BIGINT(0) NOT NULL AUTO_INCREMENT,
category_name VARCHAR(32) NULL DEFAULT NULL,
article_id BIGINT(0) NOT NULL,
PRIMARY KEY(id) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

DESC blog_category;

-- ----------------------------
-- insert test values
-- ----------------------------

INSERT INTO blog_article
VALUES (1,"Test Title1","test summary 1","test content 1",'2022-11-17 08:21:22',1,NULL,0);

INSERT INTO blog_article
VALUES (2,"Test Title2","test summary 2","test content 2",'2022-11-18 10:21:22',1,NULL,0);




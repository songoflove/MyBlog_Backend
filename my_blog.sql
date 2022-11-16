-- ----------------------------
-- Table structure for blog_account
-- ----------------------------
DROP TABLE IF EXISTS blog_account;
CREATE TABLE blog_account (
id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(64) NOT NULL,
`password` VARCHAR(64) NOT NULL,
created_date DATETIME DEFAULT NULL,
PRIMARY KEY(id) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS blog_article;
CREATE TABLE blog_article (
id INT NOT NULL AUTO_INCREMENT,
title VARCHAR(64) NOT NULL,
summary VARCHAR(255) NOT NULL,
`content` LONGTEXT,
`created_date` DATETIME NOT NULL ON UPDATE CURRENT_TIMESTAMP,
user_id INT(0) NOT NULL,
category_id INT,
view_counts INT,
PRIMARY KEY(id) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

DESC blog_article;

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
CREATE TABLE blog_category (
id INT NOT NULL AUTO_INCREMENT,
category_name VARCHAR(32) NOT NULL,
article_id INT NOT NULL,
PRIMARY KEY(id) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

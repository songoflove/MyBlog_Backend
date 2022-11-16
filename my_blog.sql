-- ----------------------------
-- Table structure for blog_account
-- ----------------------------
DROP TABLE IF EXISTS blog_account;
CREATE TABLE blog_account (
	account_id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
	`password` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
	PRIMARY KEY(account_id) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;





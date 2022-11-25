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

INSERT INTO blog_article
VALUES (3,"【日文 辛苦了】「お疲れ様」和「ご苦労様」的用法和念法解析！",
"test summary 2","日劇中公司職員常在下班時互道「辛苦了」，或是在上司在員工完成交付任務時也說了一聲「辛苦了」，但你是否曾好奇過，為什麼有時候聽到的是「お疲れ様(o tsu ka re sa ma)」，有時候卻是「ご苦労様(go ku ro u sa ma)」呢？想知道它們的分別就快來看看吧!
其實「お疲れ様(o tsu ka re sa ma)」和「ご苦労様(go ku ro u sa ma)」分別應該使用在不同的場合，以下分別作介紹：",
'2022-11-22 10:21:22',1,NULL,0);

INSERT INTO blog_article
VALUES (4,"日本語のブログ","みなさん、日本語で書かれている面白いブログ、ご存知ないですか？英語のブログをたくさん読んでますけど、日本語のブログは全然です。",
"みなさん、日本語で書かれている面白いブログ、ご存知ないですか？英語のブログをたくさん読んでますけど、日本語のブログは全然です。

人気ブログランキングがあるんですが、範囲が広すぎて、面白いブログを探すのがめんどくさいです。有名人のブログも人気あるようですが、個人的にはあまり好きじゃないし、私みたいな凡人よりもっと面白い人生を送っているようで、なんかムカつきます。

ちにまに、私が読んでいるブログは、この日本語教師のブログぐらいです。日本語に興味なくても、なかなか面白いですよ。

コメントで面白いブログをシェアーしましょう！

最後に．．．（もう遅いけど）

あけましておめでとうございます！

今年もよろしくお願いします。これからも、コメントをじゃんじゃん書いてね！",'2022-11-22 12:21:22',1,NULL,0);

INSERT INTO blog_article
VALUES (5,"はたしてダイソーの豆炭で焼き芋は作れるのか…","一昨日は二日酔いが酷くて、とてもじゃないがブログなんて書けぬと思ったので、",
"にほんブログ村さんの日本一周とキャンピングカー部門で、注目記事１位になってしまいました…、良いのでしょうか・・・・・、一体誰が注目したのでしょうか・・・・・、一生懸命ブログを書かれている皆様・・・、すみません…です。",
'2022-11-22 09:21:22',1,NULL,0);



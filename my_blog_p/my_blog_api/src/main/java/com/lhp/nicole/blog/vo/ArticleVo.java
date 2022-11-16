package com.lhp.nicole.blog.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ArticleVo {
    private int id;
    private String title;
    private String summary;
    private String content;
    private Timestamp created_date;

    private int user_id;

    private int view_counts;
}

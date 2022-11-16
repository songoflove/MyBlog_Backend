package com.lhp.nicole.blog.vo;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class ArticleVo {
    private Integer id;
    private String title;
    private String summary;
    private String content;
    private LocalDateTime created_date;

    private Integer user_id;

    private Integer view_counts;
}

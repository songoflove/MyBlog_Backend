package com.lhp.nicole.blog.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleVo {
    private Long id;
    private String title;
    private String summary;
    private String content;
    private LocalDateTime createdDate;
    private int viewCounts;
}

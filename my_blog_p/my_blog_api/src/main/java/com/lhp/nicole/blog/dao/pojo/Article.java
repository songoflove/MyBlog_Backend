package com.lhp.nicole.blog.dao.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class Article {
    private Long id;
    private String title;
    private String summary;
    private String content;
    private LocalDateTime createdDate;
    /*
    * author id
    * */
    private Long userId;
    private Long categoryId;
    /*
    * viewer
    * */
    private int viewCounts;
}

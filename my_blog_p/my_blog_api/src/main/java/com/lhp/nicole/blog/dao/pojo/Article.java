package com.lhp.nicole.blog.dao.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class Article {
    private Integer id;
    private String title;
    private String summary;
    private String content;
    private LocalDateTime created_date;
    /*
    * author id
    * */
    private int user_id;
    /*
    * viewer
    * */
    private int view_counts;
}

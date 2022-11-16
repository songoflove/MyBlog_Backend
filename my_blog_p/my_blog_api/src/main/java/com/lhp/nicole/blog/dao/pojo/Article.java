package com.lhp.nicole.blog.dao.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Article {
    private int id;
    private String title;
    private String summary;
    private String content;
    private Timestamp created_date;
    /*
    * author id
    * */
    private int user_id;
    /*
    * viewer
    * */
    private int view_counts;
}

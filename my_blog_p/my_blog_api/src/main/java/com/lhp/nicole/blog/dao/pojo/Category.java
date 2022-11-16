package com.lhp.nicole.blog.dao.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Category {

    private int id;

    private String category_name;

    private int article_id;

}

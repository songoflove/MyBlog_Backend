package com.lhp.nicole.blog.dao.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Category {

    private Integer id;

    private String category_name;

    private Integer article_id;

}

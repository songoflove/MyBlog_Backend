package com.lhp.nicole.blog.dao.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Category {
    private Long id;
    private String categoryName;
    private Long articleId;

}

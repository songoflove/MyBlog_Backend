package com.lhp.nicole.blog.dao.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Account {

    private int id;

    private String username;

    private String password;

    private Timestamp created_date;
}

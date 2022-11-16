package com.lhp.nicole.blog.dao.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class Account {

    private Integer id;

    private String username;

    private String password;

    private LocalDateTime created_date;
}

package com.lhp.nicole.blog.dao.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Account {

    private Long id;

    private String username;

    private String password;

    private LocalDateTime createdDate;
}

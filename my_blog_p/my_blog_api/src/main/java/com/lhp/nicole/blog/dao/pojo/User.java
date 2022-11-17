package com.lhp.nicole.blog.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
/*    @TableId(type = IdType.ASSIGN_ID) //default id type by mybatis-plus
    @TableId(type = IdType.AUTO) // 数据库自增式id
*/
    private Long id;
    private String username;
    private String password;
    private LocalDateTime createdDate;
}

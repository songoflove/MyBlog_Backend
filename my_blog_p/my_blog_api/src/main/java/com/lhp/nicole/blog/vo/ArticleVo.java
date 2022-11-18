package com.lhp.nicole.blog.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleVo {
//   @JsonSerialize(using = ToStringSerializer.class)  //json序列化 防止精度损失
    private Long id;
    private String title;
    private String summary;
    private String content;
    private LocalDateTime createdDate;
    private int viewCounts;
//    private CategoryVo category;
}

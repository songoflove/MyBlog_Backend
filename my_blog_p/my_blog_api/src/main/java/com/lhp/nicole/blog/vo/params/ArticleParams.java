package com.lhp.nicole.blog.vo.params;

import lombok.Data;

@Data
public class ArticleParams {
    private String summary;
    private String content;
    private String title;
    private Long id;

    public ArticleParams(String summary, String content, String title) {
        this.summary = summary;
        this.content = content;
        this.title = title;
    }
    public ArticleParams(String summary, String content, String title,Long id) {
        this.summary = summary;
        this.content = content;
        this.title = title;
        this.id = id;
    }
    
}

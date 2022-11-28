package com.lhp.nicole.blog.service;

import com.lhp.nicole.blog.vo.params.ArticleParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;
    @Test
    void listArticle() {
    }

    @Test
    void testAddArticle_BlankSummary_ReturnFailure(){
        String summary = "";
        String title = "ttt";
        String content = "ccc";
        ArticleParams articleParams = new ArticleParams(summary,content,title);
        Assertions.assertEquals(1001,articleService.addArticle(articleParams).getCode());
    }
    @Test
    void testAddArticle_BlankTitle_ReturnFailure(){
        String summary = "sss";
        String title = "";
        String content = "ccc";
        ArticleParams articleParams = new ArticleParams(summary,content,title);
        Assertions.assertEquals(1001,articleService.addArticle(articleParams).getCode());
    }
    @Test
    void testAddArticle_BlankContent_ReturnFailure(){
        String summary = "sss";
        String title = "ttt";
        String content = "";
        ArticleParams articleParams = new ArticleParams(summary,content,title);
        Assertions.assertEquals(1001,articleService.addArticle(articleParams).getCode());
    }

    @Test
    void editArticle() {
    }

    @Test
    void deleteArticle() {
    }
}
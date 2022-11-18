package com.lhp.nicole.blog.controller;

import com.lhp.nicole.blog.service.ArticleService;
import com.lhp.nicole.blog.vo.Result;
import com.lhp.nicole.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//use json data
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    /*
    * get homepage article list
    * @param pageParams
    * @return
    * */
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams){
        return articleService.listArticle(pageParams);
    }

    @PostMapping("/details/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId){
        return articleService.findArticleById(articleId);
    }
}

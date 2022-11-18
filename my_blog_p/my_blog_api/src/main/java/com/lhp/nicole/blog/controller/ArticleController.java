package com.lhp.nicole.blog.controller;

import com.lhp.nicole.blog.service.ArticleService;
import com.lhp.nicole.blog.vo.Result;
import com.lhp.nicole.blog.vo.params.ArticleParams;
import com.lhp.nicole.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//use json data
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams){
        return articleService.listArticle(pageParams);
    }

    @PostMapping("/details/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId){
        return articleService.findArticleById(articleId);
    }

    @PostMapping("/add")
    public Result addArticle(@RequestBody ArticleParams articleParams){
        return articleService.addArticle(articleParams);
    }

    @PostMapping("/edit")
    public Result editArticle(@RequestBody ArticleParams articleParams){
        return articleService.editArticle(articleParams);
    }
}

package com.lhp.nicole.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhp.nicole.blog.dao.mapper.ArticleMapper;
import com.lhp.nicole.blog.dao.pojo.Article;
import com.lhp.nicole.blog.service.ArticleService;
import com.lhp.nicole.blog.vo.ArticleVo;
import com.lhp.nicole.blog.vo.Result;
import com.lhp.nicole.blog.vo.params.PageParams;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result listArticle(PageParams pageParams) {
        /*分页查询article数据库表 得到结果*/
        Page<Article> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //倒序排列文章
        queryWrapper.orderByDesc(Article::getCreated_date);
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        //vo中是前端页面所需要的数据
        List<Article> records = articlePage.getRecords();
        List<ArticleVo> articleVoList = copyList(records);
        return Result.success(articleVoList);
    }
    //复制article中的数据到articleVo
    private List<ArticleVo> copyList(List<Article> records) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record));
        }
        return articleVoList;
    }

    private ArticleVo copy(Article article){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article,articleVo);
//        articleVo.setCreated_date(new Timestamp(article.getCreated_date()).toString("yyyy-MM-dd HH:mm"));
        return articleVo;
    }
}

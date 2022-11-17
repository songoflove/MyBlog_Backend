package com.lhp.nicole.blog.service;

import com.lhp.nicole.blog.vo.Result;
import com.lhp.nicole.blog.vo.params.PageParams;

public interface ArticleService {
    /*
     * 分页查询 文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);
}

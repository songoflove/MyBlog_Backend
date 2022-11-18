package com.lhp.nicole.blog.service;

import com.lhp.nicole.blog.vo.Result;
import com.lhp.nicole.blog.vo.params.PageParams;

public interface ArticleService {
    /*
     * View article list
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);

    /*
     * View article details
     * @params articleId
     * @return
     */
    Result findArticleById(Long articleId);
}

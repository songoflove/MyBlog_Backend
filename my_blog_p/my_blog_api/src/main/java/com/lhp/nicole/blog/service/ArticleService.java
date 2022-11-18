package com.lhp.nicole.blog.service;

import com.lhp.nicole.blog.vo.Result;
import com.lhp.nicole.blog.vo.params.ArticleParams;
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

    /*
     * add new article
     * @param articleParams
     * @return
     * */
    Result addArticle(ArticleParams articleParams);

    /*
     * edit article
     * @params articleParams
     * @return
     */
    Result editArticle(ArticleParams articleParams);
}

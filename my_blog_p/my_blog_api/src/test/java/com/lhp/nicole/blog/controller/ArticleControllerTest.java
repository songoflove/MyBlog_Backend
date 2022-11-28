package com.lhp.nicole.blog.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class ArticleControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void listArticle_Succeed() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/articles")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("page", String.valueOf(1))
                .param("pageSize", String.valueOf(10));
        mockMvc.perform(request);
    }

    @Test
    void addArticle() {
    }

    @Test
    void editArticle() {
    }

    @Test
    void deleteArticle() {
    }
}
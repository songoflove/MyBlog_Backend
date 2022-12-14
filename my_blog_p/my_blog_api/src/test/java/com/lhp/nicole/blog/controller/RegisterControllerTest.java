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
class RegisterControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void testReigster_Succeed() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/register")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("username","adminNewRegi")
                .param("password","adminNewRegi");
        mockMvc.perform(request);
    }
}
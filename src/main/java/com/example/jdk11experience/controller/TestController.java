package com.example.jdk11experience.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Chauncey Sun
 * @create 2021/4/29 12:00
 */
public class TestController {
    @RequestMapping(value = "/dshjbca")
    public String test1(){
        return "dfs";
    }
}

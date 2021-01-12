package com.qf.controller;

import com.qf.pojo.resp.BaseResp;
import com.qf.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @RequestMapping("/findById")
    public BaseResp findById(@RequestBody Map map){
        return articleService.findById(map);
    }

}

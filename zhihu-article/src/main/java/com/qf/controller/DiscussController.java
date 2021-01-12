package com.qf.controller;

import com.qf.pojo.Discuss;
import com.qf.pojo.resp.BaseResp;
import com.qf.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/discuss")
@CrossOrigin
public class DiscussController {
    @Autowired
    DiscussService discussService;
    @RequestMapping("/deleteById")
    public BaseResp deleteById(@RequestBody Map map){
        return discussService.deleteById(map);
    }
    @RequestMapping("/insertDiscuss")
    public BaseResp insertDiscuss(@RequestBody Discuss discuss) {
        return discussService.insertDiscuss(discuss);
    }
}

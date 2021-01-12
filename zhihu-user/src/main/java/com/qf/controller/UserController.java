package com.qf.controller;

import com.qf.pojo.resp.BaseResp;
import com.qf.service.UserService;
import com.qf.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
     UploadUtils uploadUtils;
    @RequestMapping("/findById")
    public BaseResp findById(@RequestBody Map map){
        return userService.findById(map);
    }
    @RequestMapping("/createStaticThymeleaf")
    public BaseResp createStaticThymeleaf(@RequestBody Map map) throws IOException {
        return userService.createStaticThymeleaf((Integer)map.get("id"));
    }

    @RequestMapping(value = "/findUrl",method = RequestMethod.POST)
    public BaseResp findUrl(@RequestBody Map map){
        System.out.println(map.get("id"));
        return userService.findUrl(map);
    }
    @RequestMapping(value = "/uploadPicture")
    public BaseResp uploadPicture(@RequestParam("file") MultipartFile multipartFile){
        System.out.println("dsa");
        BaseResp baseResp = uploadUtils.upload(multipartFile);
        System.out.println("baseResp = " + baseResp.getData());
        return baseResp;
    }
}

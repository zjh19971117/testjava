package com.qf.service;

import com.qf.pojo.resp.BaseResp;

import java.io.IOException;
import java.util.Map;

public interface UserService {

    BaseResp findById(Map map);

    BaseResp createStaticThymeleaf(Integer id) throws IOException;

    BaseResp findUrl(Map map);
}

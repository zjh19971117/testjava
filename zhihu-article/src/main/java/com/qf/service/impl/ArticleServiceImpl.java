package com.qf.service.impl;

import com.qf.dao.ArticleMapper;
import com.qf.pojo.resp.BaseResp;
import com.qf.pojo.States;
import com.qf.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired(required = false)
    ArticleMapper articleMapper;
    @Override
    public BaseResp findById(Map map) {
        Integer id = (Integer) map.get("id");
        States states = articleMapper.findById(id);
        BaseResp baseResp = new BaseResp();
        baseResp.setData(states);
        baseResp.setCode(200);
        baseResp.setMsg("查询成功");
        return baseResp;
    }


}

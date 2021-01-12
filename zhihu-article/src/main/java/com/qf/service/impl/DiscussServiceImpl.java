package com.qf.service.impl;

import com.qf.dao.DiscussMapper;
import com.qf.pojo.Discuss;
import com.qf.pojo.resp.BaseResp;
import com.qf.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DiscussServiceImpl implements DiscussService {
    @Autowired(required = false)
    DiscussMapper discussMapper;
    @Override
    public BaseResp deleteById(Map map) {
        Integer id = (Integer) map.get("id");
        Integer i = discussMapper.deleteById(id);
        BaseResp baseResp = new BaseResp();
        baseResp.setMsg("删除成功");
        baseResp.setCode(200);
        baseResp.setData(i);
        return baseResp;
    }

    @Override
    public BaseResp insertDiscuss(Discuss discuss) {
        Integer i = discussMapper.insertDiscuss(discuss);
        BaseResp baseResp = new BaseResp();
        baseResp.setData(i);
        baseResp.setCode(200);
        baseResp.setMsg("插入成功");
        return baseResp;
    }

}

package com.qf.service;

import com.qf.pojo.Discuss;
import com.qf.pojo.resp.BaseResp;

import java.util.Map;

public interface DiscussService {
    BaseResp deleteById(Map map);
    BaseResp insertDiscuss(Discuss discuss);
}

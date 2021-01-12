package com.qf.service.impl;

import com.qf.dao.UserMapper;
import com.qf.pojo.State;
import com.qf.pojo.resp.BaseResp;
import com.qf.service.UserService;
import com.qf.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired
    UploadUtils uploadUtils;
    @Autowired
    TemplateEngine templateEngine;

    @Override
    public BaseResp findById(Map map) {
        Integer id = (Integer) map.get("id");
        State state = userMapper.findById(id);
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(200);
        baseResp.setMsg("查询成功");
        baseResp.setData(state);
        return baseResp;
    }

    @Override
    public BaseResp createStaticThymeleaf(Integer id) throws IOException {
        //生命获取静态化的页面
        Context context = new Context();
        //查询数据
        State byId = userMapper.findById(id);
        //页面和数据结合
        context.setVariable("state", byId);
        String stateTemplate = templateEngine.process("StateTemplate",context);
        System.out.println(stateTemplate);
        //声明一个uuid
        UUID uuid = UUID.randomUUID();
            /*BaseResp baseResp = uploadUtils.uploadString(goodsTemplate);
        //获取到上传后的url
        Object data = baseResp.getData();

        //将静态化页面的地址放置再数据中
        byId.setStaticUrl(data.toString());*/
        FileOutputStream file = new FileOutputStream(new File("E:/source/file/"+uuid.toString()+".html"));
        file.write(stateTemplate.getBytes("utf-8"));
        file.close();
        byId.setPath("E:/source/file/"+uuid.toString()+".html");
        userMapper.updateById(byId);
        return null;
    }

    @Override
    public BaseResp findUrl(Map map) {
        String  str = userMapper.findUrl((Integer) map.get("id"));
        if(str !=null || !str.isEmpty()){
            String url = str.replaceAll("E:/source","http://10.12.154.51:8889");
            System.out.println(url);
            BaseResp baseResp = new BaseResp();
            baseResp.setData(url);
            baseResp.setCode(200);
            return baseResp;
        }else {
            return null;
        }

    }
}

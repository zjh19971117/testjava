package com.qf.dao;

import com.qf.pojo.Discuss;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DiscussMapper {
    Integer deleteById(@Param("id") Integer id);
    Integer insertDiscuss(Discuss discuss);
}

package com.qf.dao;

import com.qf.pojo.State;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    State findById(@Param("id") Integer id);

    void updateById(State byId);

    String findUrl(Integer map);
}

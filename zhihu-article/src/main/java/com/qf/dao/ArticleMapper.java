package com.qf.dao;
import com.qf.pojo.States;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    States findById(@Param("id") Integer id);


}

package com.example.yuetan.dao;

import com.example.yuetan.model.EntireResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EntireResultDao {

    @Select("select * from video_result where location=#{loc} and direction=#{dir} and time=#{tim}")
    List<EntireResult> getEntireResultByLocDirTim(@Param("loc") String location,
                                                  @Param("dir") String direction,
                                                  @Param("tim") String time);    //查询指定地点方向时间的全部数据
}

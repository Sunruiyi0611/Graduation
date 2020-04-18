package com.example.yuetan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.List;
import static com.example.yuetan.util.Config.VIDEO;

@Mapper
@Component
public interface OptionsDao {

    @Select("SELECT DISTINCT location " +
            "FROM " + VIDEO)
    List<String> getLocations();
}

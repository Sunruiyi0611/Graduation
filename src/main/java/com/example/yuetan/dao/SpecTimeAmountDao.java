package com.example.yuetan.dao;

import com.example.yuetan.model.SpecTimeAmount;
import javafx.scene.media.VideoTrack;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.yuetan.util.Config.VIDEO;

@Mapper
@Component
public interface SpecTimeAmountDao {

    @Select("select"
            + " people_amount,"
            + " bike_amount,"
            + " car_amount,"
            + " electrombile_amount,"
            + " specific_time"
            + " from "
            + VIDEO
            + " where location=#{loc}"
            + " and direction=#{dir}"
            + " and time=#{tim}")
    List<SpecTimeAmount> getSpecTimeAmountWithLocDirTime(@Param("loc") String location,
                                                         @Param("dir") String direction,
                                                         @Param("tim") String time);
    //查询指定地点方向时间的时间和数量

    @Select("select"
            + " SUM(people_amount) as people_amount,"
            + " SUM(bike_amount) as bike_amount,"
            + " SUM(car_amount) as car_amount,"
            + " SUM(electrombile_amount) as electrombile_amount,"
            + " specific_time"
            + " from "
            + VIDEO
            + " where location=#{loc}"
            + " and time=#{tim}"
            + " group by specific_time")
    List<SpecTimeAmount> getSpecTimeAmountWithLocTime(@Param("loc") String location,
                                                      @Param("tim") String time);
}

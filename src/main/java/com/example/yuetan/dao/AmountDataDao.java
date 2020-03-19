package com.example.yuetan.dao;

import com.example.yuetan.model.AmountData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import static com.example.yuetan.util.Config.VIDEO;

@Mapper
@Component
public interface AmountDataDao {

    @Select("SELECT " +
            "SUM(people_amount) AS people, " +
            "SUM(bike_amount) AS bike, " +
            "SUM(car_amount) AS car, " +
            "SUM(electrombile_amount) AS electrombile " +
            "FROM " + VIDEO +
            " WHERE location=#{loc}" +
            " AND direction=#{dir}" +
            " AND time=#{time}" +
            " AND specific_time>=#{start}" +
            " AND specific_time<=#{end}")
    AmountData getAmountData(@Param("loc") String location,
                             @Param("dir") String direction,
                             @Param("time") String time,
                             @Param("start") float start,
                             @Param("end") float end);

    @Select("SELECT " +
            "SUM(people_amount) AS people, " +
            "SUM(bike_amount) AS bike, " +
            "SUM(car_amount) AS car, " +
            "SUM(electrombile_amount) AS electrombile " +
            "FROM " + VIDEO +
            " WHERE location=#{loc}" +
            " AND time=#{time}" +
            " AND specific_time>=#{start}" +
            " AND specific_time<=#{end}")
    AmountData getAmountDataWithoutDir(@Param("loc") String location,
                                       @Param("time") String time,
                                       @Param("start") float start,
                                       @Param("end") float end);

}

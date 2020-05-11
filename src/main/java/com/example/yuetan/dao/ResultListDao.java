package com.example.yuetan.dao;

import com.example.yuetan.model.AmountData;
import com.example.yuetan.model.ResultList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.yuetan.util.Config.VIDEO;

@Mapper
@Component
public interface ResultListDao {

    //折线图的无方向的查询结果列表
    @Select("select"
            + " direction,"
            + " people_amount,"
            + " bike_amount,"
            + " car_amount,"
            + " electrombile_amount,"
            + " specific_time"
            + " from "
            + VIDEO
            + " where location=#{loc}"
            + " and time=#{tim}"
            + " order by specific_time")
    List<ResultList> getResultListWithLocTime(@Param("loc") String location,
                                                  @Param("tim") String time);

    //饼状图的查询列表
    @Select("SELECT " +
            "direction, " +
            "people_amount, " +
            "bike_amount, " +
            "car_amount, " +
            "electrombile_amount, " +
            "specific_time " +
            "FROM " + VIDEO +
            " WHERE location=#{loc}" +
            " AND direction=#{dir}" +
            " AND time=#{time}" +
            " AND specific_time>=#{start}" +
            " AND specific_time<=#{end}" +
            " order by specific_time")
    List<ResultList> getPieList(@Param("loc") String location,
                             @Param("dir") String direction,
                             @Param("time") String time,
                             @Param("start") float start,
                             @Param("end") float end);

    //饼状图的无方向查询列表
    @Select("SELECT " +
            "direction, " +
            "people_amount, " +
            "bike_amount, " +
            "car_amount, " +
            "electrombile_amount, " +
            "specific_time " +
            "FROM " + VIDEO +
            " WHERE location=#{loc}" +
            " AND time=#{time}" +
            " AND specific_time>=#{start}" +
            " AND specific_time<=#{end}" +
            " order by specific_time")
    List<ResultList> getPieListWithoutDir(@Param("loc") String location,
                                       @Param("time") String time,
                                       @Param("start") float start,
                                       @Param("end") float end);

    //柱状图展示列表
    @Select("SELECT " +
            "direction, " +
            "people_amount, " +
            "bike_amount, " +
            "car_amount, " +
            "electrombile_amount, " +
            "specific_time "+
            "FROM " + VIDEO +
            " WHERE location=#{loc}" +
            " AND direction=#{dir}" +
            " AND time=#{time}" +
            " AND specific_time>=#{start}" +
            " AND specific_time<=#{end}"+
            " order by specific_time")
    List<ResultList> getBarList(@Param("loc") String location,
                                 @Param("dir") String direction,
                                 @Param("time") String time,
                                 @Param("start") float start,
                                 @Param("end") float end);
    //柱状图的无方向展示列表
    @Select("SELECT " +
            "direction, " +
            "people_amount, " +
            "bike_amount, " +
            "car_amount, " +
            "electrombile_amount, " +
            "specific_time "+
            "FROM " + VIDEO +
            " WHERE location=#{loc}" +
            " AND time=#{time}" +
            " AND specific_time>=#{start}" +
            " AND specific_time<=#{end}" +
            " order by specific_time")
    List<ResultList> getBarListWithDir(@Param("loc") String location,
                                           @Param("time") String time,
                                           @Param("start") float start,
                                           @Param("end") float end);
}

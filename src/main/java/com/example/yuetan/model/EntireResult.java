package com.example.yuetan.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntireResult {

    int id;

    String location;            //录制地点

    String direction;           //录制地点方向

    String time;                //录制时间 周中、周末

    int people_amoumt;          //记录人数

    int bike_amount;            //记录自行车数

    int car_amount;             //记录车辆数

    int electrombile_amount;    //电动车数量

    float specific_time;        //录制具体时间点（均为10分钟长度）



}

package com.example.yuetan.model;

//作为前端展示的数据

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ResultList {

    String direction;           //记录方向

    int people_amount;          //记录人数

    int bike_amount;            //记录自行车数

    int car_amount;             //记录车辆数

    int electrombile_amount;    //电动车数量

    float specific_time;        //录制具体时间点（均为10分钟长度）



}

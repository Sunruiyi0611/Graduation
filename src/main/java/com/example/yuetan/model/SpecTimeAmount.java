package com.example.yuetan.model;

//具体时间点的数据

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecTimeAmount implements Comparable<SpecTimeAmount>{

    int people_amoumt;          //记录人数

    int bike_amount;            //记录自行车数

    int car_amount;             //记录车辆数

    int electrombile_amount;    //电动车数量

    float specific_time;        //录制具体时间点（均为10分钟长度）

    @Override
    public int compareTo(SpecTimeAmount o) {
        return (int) (this.getSpecific_time()-o.getSpecific_time());
    }
}

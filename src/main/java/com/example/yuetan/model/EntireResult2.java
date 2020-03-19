package com.example.yuetan.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EntireResult2 {    //line chart

    String location;            //录制地点

    String direction;           //录制地点方向

    String time;                //录制时间 周中、周末

    List<SpecTimeAmount> amountList; //指定地点、方向、天的各个时间段的数据
}

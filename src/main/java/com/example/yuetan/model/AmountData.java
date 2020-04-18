package com.example.yuetan.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AmountData {   //pie & bar chart

    int people;          //记录人数

    int bike;            //记录自行车数

    int car;             //记录车辆数

    int electrombile;    //电动车数量

}

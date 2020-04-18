package com.example.yuetan.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result4Bar {

    String location;

    String direction;

    float start;    //时间范围起始时间

    float end;      //终止时间

    AmountData midweek;     //周中数据

    AmountData weekend;     //周末数据
}

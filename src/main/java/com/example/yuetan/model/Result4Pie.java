package com.example.yuetan.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result4Pie {

    String location;

    String direction;

    String day;     //周中/周末

    float start;    //时间范围起始时间

    float end;      //终止时间

    AmountData amountData;
}

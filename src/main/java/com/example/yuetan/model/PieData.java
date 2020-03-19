package com.example.yuetan.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PieData {

    String name;

    int value;

    public PieData(String name, int value){
        this.name = name;
        this.value =value;
    }
}

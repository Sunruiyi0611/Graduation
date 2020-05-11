package com.example.yuetan.enums;

public enum DirectionEnum {

    South2North("南向北"),
    North2South("北向南"),
    West2East("西向东"),
    East2West("东向西"),
    NORTHWEST("西北"),
    NORTHEAST("东北"),
    SOUTHWEST("西南"),
    SOUTHEAST("东南"),
    NoDirection("无");

    public String  name;

    DirectionEnum(String name){
        this.name=name;
    }
}

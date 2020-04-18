package com.example.yuetan.enums;

public enum LocationEnum {

    BeijingBank("北京银行"),
    Bei2Xiang("北二巷"),
    Bei3Xiang("北三巷"),
    ErHuanXiCe("二环西侧"),
    ErQiJuChang("二七剧场"),
    Nan2Xiang("南二巷"),
    NanHengJie16("南横街16"),
    NanHengJie17("南横街17"),
    NanHengJie18("南横街18"),
    NanHengJie19("南横街19"),
    NanHengJieXi("南横街西"),
    NanLiShiLu("南礼士路"),
    NanLiShiLuDong("南礼士路路口东"),
    NanLiShiLuXi("南礼士路路口西"),
    Nan6Xiang("南六巷"),
    Nan7Xiang("南七巷"),
    Nan3Xiang("南三巷"),
    Nan4Xiang("南四巷"),
    Nan5iang("南五巷"),
    Nan1Xiang("南一巷"),
    PaiChuSuo("派出所路口"),
    PaiChuSuoDong("派出所路口东"),
    PaiChuSuoXi("派出所路口西"),
    SanLiHe17("三里河17"),
    SanLiHeBeiJie("三里河北街"),
    SanLiHeBeiJieDong("三里河北街东"),
    SanLiHeBeiJieXi("三里河北街西"),
    SanLiHeDongLuXi("三里河东路路口东"),
    SanLiHeDongLuDong("三里河东路路口西");


    public String name;

    private LocationEnum(String name){
        this.name=name;
    }
}

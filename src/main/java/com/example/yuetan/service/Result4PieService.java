package com.example.yuetan.service;

import com.example.yuetan.model.Result4Pie;

public interface Result4PieService {

    Result4Pie getResult4Pie(String location, String direction, String time, float start, float end);

}

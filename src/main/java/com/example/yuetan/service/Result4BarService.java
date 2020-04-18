package com.example.yuetan.service;

import com.example.yuetan.model.Result4Bar;

public interface Result4BarService {

    Result4Bar getResult4Bar(String location, String direction, float start, float end);
}

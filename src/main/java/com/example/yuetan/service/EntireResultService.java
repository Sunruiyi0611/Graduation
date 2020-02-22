package com.example.yuetan.service;

import com.example.yuetan.model.EntireResult;

import java.util.List;

public interface EntireResultService {

    List<EntireResult> getEntireResultByLDT(String location, String direction, String time);
}

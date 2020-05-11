package com.example.yuetan.service;

import com.example.yuetan.model.ResultList;

import java.util.List;

public interface ResultListService {
    List<ResultList> getResultList(String location, String time);

    List<ResultList> getPieList(String location, String direction, String time, float start, float end);
}

package com.example.yuetan.service.impl;

import com.example.yuetan.dao.EntireResultDao;
import com.example.yuetan.model.EntireResult;
import com.example.yuetan.service.EntireResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntireResultServiceImpl implements EntireResultService {

    @Autowired
    private EntireResultDao entireResultDao;

    @Override
    public List<EntireResult> getEntireResultByLDT(String location, String direction, String time) {
        return entireResultDao.getEntireResultByLocDirTim(location,direction,time);
    }
}

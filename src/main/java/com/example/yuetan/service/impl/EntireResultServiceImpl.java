package com.example.yuetan.service.impl;

import com.example.yuetan.dao.EntireResultDao;
import com.example.yuetan.model.EntireResult;
import com.example.yuetan.service.EntireResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class EntireResultServiceImpl implements EntireResultService {

    @Autowired
    private EntireResultDao entireResultDao;

    @Override
    public List<EntireResult> getEntireResultByLDT(String location, String direction, String time) {
        List<EntireResult> list =entireResultDao.getEntireResultByLocDirTim(location,direction,time);
        Collections.sort(list, new Comparator<EntireResult>() {
            @Override
            public int compare(EntireResult o1, EntireResult o2) {
                return (int) (o1.getSpecific_time()-o2.getSpecific_time());
            }
        });
        return list;
    }
}

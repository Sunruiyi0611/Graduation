package com.example.yuetan.service.impl;

import com.example.yuetan.dao.ResultListDao;
import com.example.yuetan.model.ResultList;
import com.example.yuetan.service.ResultListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultListSeriveImpl implements ResultListService {

    @Autowired
    private ResultListDao resultListDao;

    @Override
    public List<ResultList> getResultList(String location, String time) {

        return resultListDao.getResultListWithLocTime(location,time);
    }

    @Override
    public List<ResultList> getPieList(String location, String direction, String time, float start, float end) {
        if (direction.equals(""))
        {
            return resultListDao.getPieListWithoutDir(location, time, start, end);
        }else {
            return resultListDao.getPieList(location, direction, time, start, end);
        }

    }
}

package com.example.yuetan.service.impl;

import com.example.yuetan.dao.SpecTimeAmountDao;
import com.example.yuetan.model.EntireResult2;
import com.example.yuetan.model.SpecTimeAmount;
import com.example.yuetan.service.EntireResult2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EntireResult2ServiceImpl implements EntireResult2Service {

    @Autowired
    private SpecTimeAmountDao specTimeAmountDao;

    private static final Logger LOG = LoggerFactory.getLogger(EntireResult2ServiceImpl.class);

    @Override
    public EntireResult2 getEntireResult(String location, String direction, String time) {

        List<SpecTimeAmount> amountlist = null;
        try {
            if (!direction.equals("")){
                amountlist = specTimeAmountDao.getSpecTimeAmountWithLocDirTime(location,direction,time);
            }
            if (direction.equals("")){
                amountlist = specTimeAmountDao.getSpecTimeAmountWithLocTime(location,time);
            }
            if(!amountlist.isEmpty()){
                Collections.sort(amountlist);
            }
            LOG.info("query amount_list from db:"+amountlist);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

        EntireResult2 entireResult2 = EntireResult2.builder()
                .location(location)
                .direction(direction)
                .time(time)
                .amountList(amountlist)
                .build();

        return entireResult2;
    }
}

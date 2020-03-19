package com.example.yuetan.service.impl;

import com.example.yuetan.dao.AmountDataDao;
import com.example.yuetan.model.AmountData;
import com.example.yuetan.model.Result4Pie;
import com.example.yuetan.service.Result4PieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Result4PieServiceImpl implements Result4PieService {

    @Autowired
    private AmountDataDao amountDataDao;

    private static final Logger LOG = LoggerFactory.getLogger(Result4PieServiceImpl.class);

    @Override
    public Result4Pie getResult4Pie(String location, String direction, String time, float start, float end) {

        AmountData amountData = null;
        Result4Pie result4Pie = null;

        try {
            if (!direction.isEmpty()) {
                //TODO 如何区分 没有查询数据和错误
                //没有查询到 只有amountData为空
                amountData = amountDataDao.getAmountData(location,direction,time,start,end);
            }
            if (direction.isEmpty()){
                amountData =amountDataDao.getAmountDataWithoutDir(location,time,start,end);
            }
            LOG.info("query amount_data | "+amountData);

            result4Pie = Result4Pie.builder()
                    .location(location)
                    .direction(direction)
                    .day(time)
                    .start(start)
                    .amountData(amountData)
                    .end(end)
                    .build();
        } catch (Exception e) {
            LOG.error("query amount_data failed |"+e);
            //查询出现错误，全部为null
        }

        return result4Pie;
    }
}

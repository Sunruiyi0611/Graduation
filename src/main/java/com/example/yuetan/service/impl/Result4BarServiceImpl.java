package com.example.yuetan.service.impl;

import com.example.yuetan.dao.AmountDataDao;
import com.example.yuetan.model.AmountData;
import com.example.yuetan.model.Result4Bar;
import com.example.yuetan.service.Result4BarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.yuetan.util.Config.MIDWEEK;
import static com.example.yuetan.util.Config.WEEKEND;

@Service
public class Result4BarServiceImpl implements Result4BarService {

    @Autowired
    private AmountDataDao amountDataDao;

    private static final Logger LOG = LoggerFactory.getLogger(Result4BarServiceImpl.class);

    @Override
    public Result4Bar getResult4Bar(String location, String direction, float start, float end) {

        AmountData midweek = null;
        AmountData weekend = null;
        Result4Bar result4Bar = null;

        try {
            if (!direction.isEmpty())
            {
                midweek = amountDataDao.getWeekAmountData(location,direction,MIDWEEK,start,end);
                weekend = amountDataDao.getWeekAmountData(location,direction,WEEKEND,start,end);
            }
            if (direction.isEmpty())
            {
                midweek = amountDataDao.getWeekAmountDataWithoutDir(location,MIDWEEK,start,end);
                weekend = amountDataDao.getWeekAmountDataWithoutDir(location,WEEKEND,start,end);
            }
            LOG.info("query amount_data for bar chart | midweek: "+midweek +" | weekend: " + weekend);

            result4Bar = Result4Bar.builder()
                    .location(location)
                    .direction(direction)
                    .start(start)
                    .end(end)
                    .midweek(midweek)
                    .weekend(weekend)
                    .build();

        } catch (Exception e) {
            LOG.error("query amount_data for bar chart failed | "+e);
        }
        return result4Bar;
    }
}

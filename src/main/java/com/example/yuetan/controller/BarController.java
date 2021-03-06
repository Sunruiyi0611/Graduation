package com.example.yuetan.controller;

import com.example.yuetan.model.Result4Bar;
import com.example.yuetan.model.ResultList;
import com.example.yuetan.service.Result4BarService;
import com.example.yuetan.service.ResultListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.yuetan.util.Config.*;


@Controller
@RequestMapping("/bar")
public class BarController {

    @Autowired
    private Result4BarService result4BarService;

    @Autowired
    private ResultListService resultListService;

    public static final Logger LOG = LoggerFactory.getLogger(BarController.class);

    @ResponseBody
    @RequestMapping("/getBarData")
    public Map<String,Object> getBarData(@RequestParam String loc,
                                         @RequestParam String dir,
                                         @RequestParam float start,
                                         @RequestParam float end){

        String msg = null;
        Map<String,Object> resultMap = new HashMap<String, Object>();

        if (start>=end)
        {
            msg = ERR_PARAM;
            resultMap.put("errMsg",msg);
            return resultMap;
        }

        Result4Bar result4Bar = null;
        List<ResultList> mid = null;
        List<ResultList> wkd = null;

        try {
            result4Bar=result4BarService.getResult4Bar(loc, dir, start, end);
            msg = SUCCESS;
            //TODO 查询为空时 空指针会报错
            LOG.info("get result for bar | "+ result4Bar.toString());
            mid = resultListService.getPieList(loc,dir,MIDWEEK,start,end);
            wkd = resultListService.getPieList(loc,dir,WEEKEND,start,end);
            LOG.info("get result_list for bar in midweek | "+ mid.toString());
            LOG.info("get result_list for bar in weekend | "+ wkd.toString());

        } catch (Exception e) {
            msg = FAILED;
            LOG.error("get result for bar failed |"+e);
        }


        resultMap.put("errMsg",msg);
        resultMap.put("res",result4Bar);
        resultMap.put("midList",mid);
        resultMap.put("weekendList",wkd);
        return resultMap;
    }
}

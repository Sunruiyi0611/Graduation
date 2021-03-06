package com.example.yuetan.controller;

import com.example.yuetan.model.PieData;
import com.example.yuetan.model.Result4Pie;
import com.example.yuetan.model.ResultList;
import com.example.yuetan.service.Result4PieService;
import com.example.yuetan.service.ResultListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.yuetan.util.Config.*;

@Controller
@RequestMapping("/pie")
public class PieController {

    @Autowired
    private Result4PieService result4PieService;

    @Autowired
    private ResultListService resultListService;

    private static final Logger LOG = LoggerFactory.getLogger(PieController.class);

    @ResponseBody
    @RequestMapping("/getPieData")
    public Map<String,Object> getPieData(@RequestParam String loc,
                                         @RequestParam String dir,
                                         @RequestParam String tim,
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

        if(tim.equals("未确定"))
        {
            tim = "无";
        }
        Result4Pie result4Pie = null;
        List list = new ArrayList<PieData>();
        List<ResultList> resultList=null;

        try {
            result4Pie = result4PieService.getResult4Pie(loc, dir, tim, start, end);
            msg = SUCCESS;
            LOG.info("get result for pie | "+ result4Pie.toString());
            if (result4Pie!=null)
            {
                list =toPieDataList(result4Pie);
            }
            resultList=resultListService.getPieList(loc, dir, tim, start, end);
            LOG.info("get result_list |"+resultList);
        } catch (Exception e) {
            msg= FAILED;
            LOG.error("get result for pie failed |"+e);
        }

        resultMap.put("errMsg",msg);
        resultMap.put("amountList",list);
        resultMap.put("resList",resultList);
        return resultMap;
    }

    public List<PieData> toPieDataList(Result4Pie result4Pie){

        List<PieData> list = new ArrayList<PieData>();
        list.add(new PieData("人",result4Pie.getAmountData().getPeople()));
        list.add(new PieData("自行车",result4Pie.getAmountData().getBike()));
        list.add(new PieData("汽车",result4Pie.getAmountData().getCar()));
        list.add(new PieData("电动车",result4Pie.getAmountData().getElectrombile()));

        return list;
    }

}

package com.example.yuetan.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.yuetan.model.EntireResult;
import com.example.yuetan.model.EntireResult2;
import com.example.yuetan.model.ResultList;
import com.example.yuetan.service.EntireResult2Service;
import com.example.yuetan.service.EntireResultService;
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

import static com.example.yuetan.util.Config.FAILED;
import static com.example.yuetan.util.Config.SUCCESS;

@Controller
@RequestMapping("/line")
public class EntireResultController {

    private static final Logger logger = LoggerFactory.getLogger(EntireResultController.class);

    @Autowired
    private EntireResultService entireResultService;

    @Autowired
    private EntireResult2Service entireResult2Service;

    @Autowired
    private ResultListService resultListService;

    @ResponseBody
    @RequestMapping("/getEntireResult")
    public Map<String,Object> getEntireResult(@RequestParam String loc,
                                              @RequestParam String dir,
                                              @RequestParam String tim){

        List<EntireResult> results =entireResultService.getEntireResultByLDT(loc,dir,tim);

        logger.info("return results={}",results.toString());

        JSONArray array= JSONArray.parseArray(JSONObject.toJSONString(results));

        Map<String,Object> resultMap =new HashMap<String, Object>();
        resultMap.put("res",array);

        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/getEntireResult2")
    public Map<String,Object> getEntireResult2(@RequestParam String loc,
                                               @RequestParam String dir,
                                               @RequestParam String tim){

        String msg = null;

        if(tim.equals("未确定"))
        {
            tim = "无";
        }

        EntireResult2 entireResult2 = null;
        List<ResultList> resultList = null;
        try {
            entireResult2 = entireResult2Service.getEntireResult(loc,dir,tim);
            if (dir.equals("")) {
                resultList=resultListService.getResultList(loc,tim);
                logger.info("return resultsList={}",resultList.toString());
            }
            logger.info("return results={}",entireResult2.toString());
            msg = SUCCESS;
        } catch (Exception e) {
            msg= FAILED;
            logger.error("get entire_result error |"+e);
        }

        Map<String,Object> resultMap =new HashMap<String, Object>();
        resultMap.put("res",entireResult2);
        resultMap.put("errMsg",msg);
        if (dir.equals(""))
        {
            resultMap.put("resList",resultList);
        }

        return resultMap;
    }



    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "hello vanilla";
    }

}

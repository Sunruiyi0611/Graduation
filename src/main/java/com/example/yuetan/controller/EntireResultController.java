package com.example.yuetan.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.yuetan.model.EntireResult;
import com.example.yuetan.service.EntireResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EntireResultController {

    private static final Logger logger = LoggerFactory.getLogger(EntireResultController.class);

    @Autowired
    private EntireResultService entireResultService;

    @ResponseBody
    @RequestMapping("/getEntireResult")
    public Map<String,Object> getEntireResult(Model model,
                               @RequestParam String loc,
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
    @RequestMapping("/test")
    public String test(){
        return "hello vanilla";
    }

}

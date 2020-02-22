package com.example.yuetan.controller;

import com.example.yuetan.dao.EntireResultDao;
import com.example.yuetan.model.EntireResult;
import com.example.yuetan.service.EntireResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EntireResultController {

    @Autowired
    private EntireResultService entireResultService;

    @ResponseBody
    @RequestMapping("/getEntireResult")
    public String getEntireResult(@RequestParam String loc,
                                  @RequestParam String dir,
                                  @RequestParam String tim){

        List<EntireResult> results =entireResultService.getEntireResultByLDT(loc,dir,tim);

        return results.toString();
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "hello vanilla";
    }

}

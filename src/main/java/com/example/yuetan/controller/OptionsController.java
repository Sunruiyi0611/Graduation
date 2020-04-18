package com.example.yuetan.controller;

import com.example.yuetan.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OptionsController {

    @Autowired
    private OptionsService optionsService;

    @RequestMapping("/getLocations")
    @ResponseBody
    public List<String> getLoction(){

        return optionsService.getLocations();
    }
}

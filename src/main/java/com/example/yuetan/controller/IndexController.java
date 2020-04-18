package com.example.yuetan.controller;

import com.example.yuetan.enums.LocationEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/line")
    public String getLine(ModelMap modelMap){
        modelMap.addAttribute("locations",LocationEnum.values());
        return "line_chart";
    }

    @RequestMapping("/line-bar")
    public String getLine2Bar(ModelMap modelMap){
        modelMap.addAttribute("locations",LocationEnum.values());
        return "line-bar";
    }

    @RequestMapping("/bar")
    public String getBar(ModelMap modelMap){
        modelMap.addAttribute("locations",LocationEnum.values());
        return "bar_chart";
    }

    @RequestMapping("/pie")
    public String getPie(ModelMap modelMap){
        modelMap.addAttribute("locations",LocationEnum.values());
        return "pie_chart";
    }
}

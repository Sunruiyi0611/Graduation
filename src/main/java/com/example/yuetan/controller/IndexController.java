package com.example.yuetan.controller;

import com.example.yuetan.enums.DirectionEnum;
import com.example.yuetan.enums.LocationEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/line")
    public String getLine(ModelMap modelMap){
        modelMap.addAttribute("locations",LocationEnum.values());
        modelMap.addAttribute("directions", DirectionEnum.values());
        return "line_chart";
    }

    @RequestMapping("/line-bar")
    public String getLine2Bar(ModelMap modelMap){
        modelMap.addAttribute("locations",LocationEnum.values());
        modelMap.addAttribute("directions", DirectionEnum.values());
        return "line-bar";
    }

    @RequestMapping("/bar")
    public String getBar(ModelMap modelMap){
        modelMap.addAttribute("locations",LocationEnum.values());
        modelMap.addAttribute("directions", DirectionEnum.values());
        return "bar_chart";
    }

    @RequestMapping("/pie")
    public String getPie(ModelMap modelMap){
        modelMap.addAttribute("locations",LocationEnum.values());
        modelMap.addAttribute("directions", DirectionEnum.values());
        return "pie_chart";
    }

    @RequestMapping("/test")
    public String getTest(ModelMap modelMap){
        modelMap.addAttribute("locations",LocationEnum.values());
        modelMap.addAttribute("directions", DirectionEnum.values());
        return "line_chart";
    }
}

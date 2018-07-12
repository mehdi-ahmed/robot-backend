package com.kahoot.interview.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Api(basePath = "/home")
@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    @ApiOperation(value = "Home page")
    @GetMapping("/kahoot/home")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
}

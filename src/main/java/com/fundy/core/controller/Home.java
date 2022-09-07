package com.fundy.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/home")
public class Home {

    @RequestMapping(value="/view")
    public String home(Model model) {
        model.addAttribute("text",
                "this is data from controller");
        return "index";
        // index 뷰를 반환
    }
}

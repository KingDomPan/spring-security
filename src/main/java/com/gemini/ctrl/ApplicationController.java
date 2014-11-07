package com.gemini.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/index")
    public String indexPage() {
        return "index";
    }

}

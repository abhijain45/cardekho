package com.cardekho.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {
    
    @GetMapping("/")
    public String index(Model model) {
        // Will later fetch cars from car-search-service
        return "index";
    }
}

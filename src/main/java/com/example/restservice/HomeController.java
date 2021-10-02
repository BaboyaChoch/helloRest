package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("")
    public String Welcome(){
        return "<h1 style=\"font-size: 100px; display: grid;" +
                "justify-content: center;" +
                "align-content: center;\">" +
                "<div>Baboya's First RESTful API</div>"+
                "</h1>";
    }
}

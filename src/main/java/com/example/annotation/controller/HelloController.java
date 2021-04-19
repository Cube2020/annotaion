package com.example.annotation.controller;

import com.example.annotation.TimerLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @TimerLog
    @GetMapping(value = "/test")
    public String test(){
        try {
            Thread.sleep(new Double(Math.random()*1000).longValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------->test");
        return "success";
    }
}

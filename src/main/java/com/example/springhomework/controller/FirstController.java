package com.example.springhomework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class FirstController {


    @GetMapping("/myData")
    public String myData(@RequestParam(value = "name", defaultValue = "John") String myName,
                         @RequestParam(value = "height", defaultValue = "180") int myHeightInCm,
                         @RequestParam(value = "weight", defaultValue = "80") int myWeightInKg,
                         Model pageParameters){
        double heightInInch = myHeightInCm * 0.3937;
        double weightInPounds = myWeightInKg * 2.20462262;
        log.info("myData() method was called!!!");
        log.info("my name is: [{}] and my height in inches is: [{}] and my weight pounds is:[{}] ", myName, myHeightInCm, myWeightInKg);

        pageParameters.addAttribute("myName", myName)
                .addAttribute("myHeight", heightInInch)
                .addAttribute("myWeight", weightInPounds);


        return "pages/myData";
    }


}

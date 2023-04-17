package com.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class ControllerCalculator {

  @GetMapping(value = "/addition")
  public String addition(){
    return "Estoy sumando";
  }

  @GetMapping(value = "/subtract")
  public String subtract(){
    return "Estoy restando";
  }
}

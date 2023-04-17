package com.calculator.controller;

import io.corp.calculator.TracerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class ControllerCalculator {

  private final TracerImpl tracer = new TracerImpl();

  @GetMapping(value = "/addition")
  public ResponseEntity<String> addition(@RequestParam(name = "firstNumber") final Integer firstNumber,
      @RequestParam(name = "secondNumber") final Integer secondNumber) {
    final int sum = firstNumber + secondNumber;
    final String result = "Suma: " + firstNumber + " + " + secondNumber + " = " + sum;
    tracer.trace(result);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping(value = "/subtract")
  public ResponseEntity<String> subtract(@RequestParam(name = "firstNumber") final Integer firstNumber,
      @RequestParam(name = "secondNumber") final Integer secondNumber) {
    final int rest = firstNumber - secondNumber;
    final String result = "Resta: " + firstNumber + " - " + secondNumber + " = " + rest;
    tracer.trace(result);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}

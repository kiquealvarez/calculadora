package com.calculator.controller;

import com.calculator.exception.ValidationException;
import com.calculator.service.IServiceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerCalculator {

  @Autowired
  private IServiceCalculator iServiceCalculator;

  @GetMapping(value = "/calculator")
  public ResponseEntity<String> calculator(@RequestParam(name = "firstNumber") final int firstNumber,
      @RequestParam(name = "secondNumber") final int secondNumber, @RequestParam(name = "operation") final String operation) {
    try {
      final String response = this.iServiceCalculator.execute(firstNumber, secondNumber, operation);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (ValidationException e) {
      return new ResponseEntity<>(e.getMsg(), HttpStatus.BAD_REQUEST);
    }
  }
}

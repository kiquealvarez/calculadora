package com.calculator.controller;

import com.calculator.exception.ValidationException;
import com.calculator.service.IServiceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class ControllerCalculator {

  @Autowired
  private IServiceCalculator iServiceCalculator;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<String> calculator(@RequestParam(value = "firstNumber") final int firstNumber,
      @RequestParam(value = "secondNumber") final int secondNumber, @RequestParam(value = "operation") final String operation) {
    try {
      final String response = this.iServiceCalculator.execute(firstNumber, secondNumber, operation);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (ValidationException e) {
      return new ResponseEntity<>(e.getMsg(), HttpStatus.BAD_REQUEST);
    }
  }
}

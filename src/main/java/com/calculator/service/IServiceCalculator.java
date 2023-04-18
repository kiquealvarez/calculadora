package com.calculator.service;

import com.calculator.exception.ValidationException;

public interface IServiceCalculator {

  String execute(int firstNumber, int secondNumber, String operation) throws ValidationException;

}

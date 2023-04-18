package com.calculator.service;

import com.calculator.exception.ValidationException;
import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

@Service
public class ServiceCalculatorImpl implements IServiceCalculator {

  private static final String ADDITION = "addition";

  private static final String SUBTRACT = "subtract";

  private final TracerImpl tracer = new TracerImpl();

  @Override
  public String execute(int firstNumber, int secondNumber, String operation) throws ValidationException {
    String result;
    if (firstNumber == 0 && secondNumber == 0) {
      result = "Ambos números tienen como valor 0.";
      tracer.trace(result);
      throw new ValidationException(result);
    } else if (ADDITION.equals(operation)) {
      final int sum = firstNumber + secondNumber;
      result = String.format("Resultado: %d + %d = %d", firstNumber, secondNumber, sum);
    } else if (SUBTRACT.equals(operation)) {
      if (firstNumber < secondNumber) {
        result = "Para restar el primer número debe ser mayor que el segundo, para que la resta no de valores negativos.";
        throw new ValidationException(result);
      } else {
        final int rest = firstNumber - secondNumber;
        result = String.format("Resultado: %d - %d = %d", firstNumber, secondNumber, rest);
      }
    } else {
      result = "De momento solo se puede realizar sumas y restas.";
      throw new ValidationException(result);
    }
    tracer.trace(result);
    return result;
  }

}

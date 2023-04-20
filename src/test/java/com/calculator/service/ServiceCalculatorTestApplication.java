package com.calculator.service;

import com.calculator.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ServiceCalculatorTestApplication.class)
class ServiceCalculatorTestApplication {

  @InjectMocks
  private IServiceCalculator serviceCalculator = new ServiceCalculatorImpl();

  private static final String ADDITION = "addition";

  private static final String SUBTRACT = "subtract";

  @Test
  @DisplayName("Ambos números tiene como valor 0")
  void valueZeroInFirstNumberAndSecondNumber() {
    final ValidationException error =
        Assertions.assertThrows(ValidationException.class, () -> this.serviceCalculator.execute(0, 0, ADDITION));

    Assertions.assertEquals("Ambos números tienen como valor 0.", error.getMsg());
  }

  @Test
  @DisplayName("Operación no aceptada")
  void otherOperation() {
    final ValidationException error =
        Assertions.assertThrows(ValidationException.class, () -> this.serviceCalculator.execute(3, 2, "multiplication"));

    Assertions.assertEquals("De momento solo se puede realizar sumas y restas.", error.getMsg());
  }

  @Test
  @DisplayName("Resta, el primer número es menor que el segundo número")
  void subtractKoSecondNumberHigherThatFirstNumber() {
    final ValidationException error =
        Assertions.assertThrows(ValidationException.class, () -> this.serviceCalculator.execute(3, 5, SUBTRACT));

    Assertions.assertEquals("Para restar el primer número debe ser mayor que el segundo, para que la resta no de valores negativos.",
        error.getMsg());
  }

  @Test
  @DisplayName("Suma correcta")
  void additionOK() {
    final String result = this.serviceCalculator.execute(3, 5, ADDITION);

    Assertions.assertNotNull(result);
    Assertions.assertEquals("Resultado: 3 + 5 = 8", result);
  }

  @Test
  @DisplayName("Resta correcta")
  void subtractOK() {
    final String result = this.serviceCalculator.execute(5, 3, SUBTRACT);

    Assertions.assertNotNull(result);
    Assertions.assertEquals("Resultado: 5 - 3 = 2", result);
  }

}

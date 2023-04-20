package com.calculator.controller;

import com.calculator.exception.ValidationException;
import com.calculator.service.IServiceCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ControllerCalculatorTestApplication.class)
class ControllerCalculatorTestApplication {

  @Mock
  private IServiceCalculator iServiceCalculator;

  @InjectMocks
  private ControllerCalculator controllerCalculator;

  @Test
  @DisplayName("ResponseEntity OK, para una suma")
  void ResponseEntityOK() {
    Mockito.when(this.iServiceCalculator.execute(3, 5, "addition")).thenReturn("Resultado: 3 + 5 = 8");

    final ResponseEntity<String> responseEntity = this.controllerCalculator.calculator(3, 5, "addition");

    Assertions.assertNotNull(responseEntity);
    Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
    Assertions.assertEquals("Resultado: 3 + 5 = 8", responseEntity.getBody());
  }

  @Test
  @DisplayName("ResponseEntity KO, se lanza la excepción ValidationException")
  void ResponseEntityKO() {
    Mockito.when(this.iServiceCalculator.execute(3, 5, "multiplication")).thenThrow(ValidationException.class);

    final ResponseEntity<String> responseEntity = this.controllerCalculator.calculator(3, 5, "multiplication");

    Assertions.assertNotNull(responseEntity);
    Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
  }

}

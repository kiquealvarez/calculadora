package com.calculator.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {

  private final String msg;

  public ValidationException(String msg) {
    this.msg = msg;
  }
}

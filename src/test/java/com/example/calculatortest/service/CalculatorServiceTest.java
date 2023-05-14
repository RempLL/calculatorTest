package com.example.calculatortest.service;

import com.example.calculatortest.exception.ByZero;
import com.example.calculatortest.service.CalculatorService;
import io.micrometer.observation.Observation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.DigestException;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest() {
        Number actual = calculatorService.plus(3, 2);
        Number expected = 5;


        Assertions.assertEquals(actual, expected);

        actual = calculatorService.plus(-1, 7);
        expected = 6;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void minusTest() {
        Number actual = calculatorService.minus(3, 2);
        Number expected = 1;


        Assertions.assertEquals(actual, expected);

        actual = calculatorService.minus(-1, 7);
        expected = -8;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void multiplyTest() {
        Number actual = calculatorService.multiply(3, 2);
        Number expected = 6;


        Assertions.assertEquals(actual, expected);

        actual = calculatorService.multiply(-1, 7);
        expected = -7;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void divideTest() {
        Number actual = calculatorService.divide(3, 2);
        Number expected = 1.5;


        Assertions.assertEquals(actual, expected);

        actual = calculatorService.divide(14, 7);
        expected = 2.0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void divideNegativeTest() {
        Assertions.assertThrows(ByZero.class, () -> calculatorService.divide(1, 0));
        Assertions.assertThrows(ByZero.class, () -> calculatorService.divide(-5, 0));
    }
}

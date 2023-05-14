package com.example.calculatortest.service;

import com.example.calculatortest.exception.ByZero;
import com.example.calculatortest.service.CalculatorService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceParametrizedTest {
    private final CalculatorService calculatorService = new CalculatorService();
    public static Stream<Arguments> plusTestParams() {
        return Stream.of(
                Arguments.of(1,2,3),
                Arguments.of(-1,2,1)
        );
    }

    public static Stream<Arguments> minusTestParams() {
        return Stream.of(
                Arguments.of(1,2,-1),
                Arguments.of(8,2,6)
        );
    }

    public static Stream<Arguments> multiplyTestParams() {
        return Stream.of(
                Arguments.of(1,2,2),
                Arguments.of(-1,2,-2)
        );
    }

    public static Stream<Arguments> divideTestParams() {
        return Stream.of(
                Arguments.of(1,2,0.5),
                Arguments.of(8,2,4.0)
        );
    }

    public static Stream<Arguments> divideNegativeTestParams() {
        return Stream.of(
                Arguments.of(1,0),
                Arguments.of(8,0)
        );
    }

    @ParameterizedTest
    @MethodSource("plusTestParams")
    public void plusTest(int a,int b, int expected) {
        Assertions.assertThat(calculatorService.plus(a,b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("minusTestParams")
    public void minusTest(int a,int b, int expected) {
        Assertions.assertThat(calculatorService.minus(a,b))
                .isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("multiplyTestParams")
    public void multiplyTest(int a,int b, int expected) {
        Assertions.assertThat(calculatorService.multiply(a,b))
                .isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("divideTestParams")
    public void divideTest(int a,int b, Number expected) {
        Assertions.assertThat(calculatorService.divide(a,b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("divideNegativeTestParams")
    public void divideNegativeTest(int a,int b) {
        Assertions.assertThatExceptionOfType(ByZero.class)
                .isThrownBy(() -> calculatorService.divide(a,b));
    }

}

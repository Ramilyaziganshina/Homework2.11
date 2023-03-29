package com.example.homework211.services;

import com.example.homework211.utils.ResultGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

@ContextConfiguration(classes = {CalcServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CalcServiceImplParamTest {

    @Autowired
    private CalcService calcService;

    public static Stream<Arguments> plusParams() {
        return Stream.of(
                Arguments.of(1.0, 1.0, ResultGenerator.plusResult(1.0, 1.0, 2.0)),
                Arguments.of(20.0, 4.0, ResultGenerator.plusResult(20.0, 4.0, 24.0)),
                Arguments.of(5.0, 5.0, ResultGenerator.plusResult(5.0, 5.0, 10.0)),
                Arguments.of(8.0, 2.0, ResultGenerator.plusResult(8.0, 2.0, 10.0))
        );
    }

    @ParameterizedTest
    @MethodSource("plusParams")
    void plus_success(Double num1, Double num2, ResponseEntity<String> expectedResult) {
        Assertions.assertEquals(calcService.plus(num1, num2), expectedResult);
    }

    public static Stream<Arguments> minusParams() {
        return Stream.of(
                Arguments.of(1.0, 1.0, ResultGenerator.minusResult(1.0, 1.0, 0.0)),
                Arguments.of(20.0, 4.0, ResultGenerator.minusResult(20.0, 4.0, 16.0)),
                Arguments.of(5.0, 5.0, ResultGenerator.minusResult(5.0, 5.0, 0.0)),
                Arguments.of(8.0, 2.0, ResultGenerator.minusResult(8.0, 2.0, 6.0))
        );
    }

    @ParameterizedTest
    @MethodSource("minusParams")
    void minus_success(Double num1, Double num2, ResponseEntity<String> expectedResult) {
        Assertions.assertEquals(calcService.minus(num1, num2), expectedResult);
    }

    public static Stream<Arguments> multiplyParams() {
        return Stream.of(
                Arguments.of(1.0, 1.0, ResultGenerator.multiplyResult(1.0, 1.0, 1.0)),
                Arguments.of(20.0, 4.0, ResultGenerator.multiplyResult(20.0, 4.0, 80.0)),
                Arguments.of(5.0, 5.0, ResultGenerator.multiplyResult(5.0, 5.0, 25.0)),
                Arguments.of(8.0, 2.0, ResultGenerator.multiplyResult(8.0, 2.0, 16.0))
        );
    }

    @ParameterizedTest
    @MethodSource("multiplyParams")
    void multiply_success(Double num1, Double num2, ResponseEntity<String> expectedResult) {
        Assertions.assertEquals(calcService.multiply(num1, num2), expectedResult);
    }

    public static Stream<Arguments> divideParams() {
        return Stream.of(
                Arguments.of(1.0, 1.0, ResultGenerator.divideResult(1.0, 1.0, 1.0)),
                Arguments.of(20.0, 4.0, ResultGenerator.divideResult(20.0, 4.0, 5.0)),
                Arguments.of(5.0, 5.0, ResultGenerator.divideResult(5.0, 5.0, 1.0)),
                Arguments.of(8.0, 2.0, ResultGenerator.divideResult(8.0, 2.0, 4.0))
        );
    }

    @ParameterizedTest
    @MethodSource("divideParams")
    void divide_success(Double num1, Double num2, ResponseEntity<String> expectedResult) {
        Assertions.assertEquals(calcService.divide(num1, num2), expectedResult);
    }
}
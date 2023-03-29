package com.example.homework211.services;

import com.example.homework211.exceptions.WrongArgumentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ContextConfiguration(classes = {CalcServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CalcServiceImplTest {

    @Autowired
    private CalcService calcService;

    @Test
    void plus_success() {
        Double num1 = 3.0;
        Double num2 = 4.0;

        String answer = "3.0 + 4.0 = 7.0";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        ResponseEntity<String> actualResult = calcService.plus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void plus_success2() {
        Double num1 = 0.0;
        Double num2 = 0.0;

        String answer = "0.0 + 0.0 = 0.0";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        ResponseEntity<String> actualResult = calcService.plus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void minus_success() {
        Double num1 = 3.0;
        Double num2 = 4.0;

        String answer = "3.0 - 4.0 = -1.0";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        ResponseEntity<String> actualResult = calcService.minus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void minus_success2() {
        Double num1 = 5.0;
        Double num2 = 5.0;

        String answer = "5.0 - 5.0 = 0.0";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        ResponseEntity<String> actualResult = calcService.minus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void multiply_success() {
        Double num1 = 3.0;
        Double num2 = 4.0;

        String answer = "3.0 * 4.0 = 12.0";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        ResponseEntity<String> actualResult = calcService.multiply(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void multiply_success2() {
        Double num1 = 5.0;
        Double num2 = 5.0;

        String answer = "5.0 * 5.0 = 25.0";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        ResponseEntity<String> actualResult = calcService.multiply(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void divide_success() {
        Double num1 = 12.0;
        Double num2 = 4.0;

        String answer = "12.0 : 4.0 = 3.0";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        ResponseEntity<String> actualResult = calcService.divide(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void divide_success2() {
        Double num1 = 5.0;
        Double num2 = 5.0;

        String answer = "5.0 : 5.0 = 1.0";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        ResponseEntity<String> actualResult = calcService.divide(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void divide_withWrongArgumentException() {
        Double num1 = 12.0;
        Double num2 = 0.0;

        Exception exception = assertThrows(
                WrongArgumentException.class,
                () -> {
                    calcService.divide(num1, num2);
                }
        );
        String expectedMessage = "на ноль делить нельзя";

        assertEquals(expectedMessage, exception.getMessage());

    }
}
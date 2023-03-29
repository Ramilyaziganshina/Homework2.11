package com.example.homework211.services;

import com.example.homework211.exceptions.WrongArgumentException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {

    public ResponseEntity<String> plus(Double num1, Double num2) {
        double result = num1 + num2;
        String answer = String.format("%s + %s = %s", num1, num2, result);
        return ResponseEntity.ok(answer);
    }

    public ResponseEntity<String> minus(Double num1, Double num2) {
        double result = num1 - num2;
        String answer = String.format("%s - %s = %s", num1, num2, result);
        return ResponseEntity.ok(answer);
    }

    public ResponseEntity<String> multiply(Double num1, Double num2) {
        double result = num1 * num2;
        String answer = String.format("%s * %s = %s", num1, num2, result);
        return ResponseEntity.ok(answer);
    }

    public ResponseEntity<String> divide(Double num1, Double num2) {
        if (num2 == 0) {
            throw new WrongArgumentException("на ноль делить нельзя");
        }
        double result = num1 / num2;
        String answer = String.format("%s : %s = %s", num1, num2, result);
        return ResponseEntity.ok(answer);
    }
}

package com.example.homework211.utils;

import org.springframework.http.ResponseEntity;

public class ResultGenerator {
    public static ResponseEntity<String> plusResult(Double num1, Double num2, Double result) {
        return ResponseEntity.ok(String.format("%s + %s = %s", num1, num2, result));
    }

    public static ResponseEntity<String> minusResult(Double num1, Double num2, Double result) {
        return ResponseEntity.ok(String.format("%s - %s = %s", num1, num2, result));
    }

    public static ResponseEntity<String> multiplyResult(Double num1, Double num2, Double result) {
        return ResponseEntity.ok(String.format("%s * %s = %s", num1, num2, result));
    }

    public static ResponseEntity<String> divideResult(Double num1, Double num2, Double result) {
        return ResponseEntity.ok(String.format("%s : %s = %s", num1, num2, result));
    }
}

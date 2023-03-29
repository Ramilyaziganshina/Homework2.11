package com.example.homework211.controllers;


import com.example.homework211.services.CalcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @RequestMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @RequestMapping("/plus")
    public ResponseEntity<String> plus(double num1, double num2) {
        return calcService.plus(num1, num2);
    }

    @RequestMapping("/minus")
    public ResponseEntity<String> minus(double num1, double num2) {
        return calcService.minus(num1, num2);
    }

    @RequestMapping("/multiply")
    public ResponseEntity<String> multiply(double num1, double num2) {
        return calcService.multiply(num1, num2);
    }

    @RequestMapping("/divide")
    public ResponseEntity<String> divide(double num1, double num2) {
        return calcService.divide(num1, num2);
    }
}

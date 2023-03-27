package com.example.homework211.controllers;


import com.example.homework211.exceptions.DivisionByZeroException;
import com.example.homework211.exceptions.NotEnoughParameters;
import com.example.homework211.services.CalcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @ExceptionHandler(DivisionByZeroException.class)
    public ResponseEntity<?> handleDivisionByZero(DivisionByZeroException e) {
        return ResponseEntity.badRequest().body("На ноль делить нельзя");
    }

    @ExceptionHandler(NotEnoughParameters.class)
    public ResponseEntity<?> handleNotEnoughParameters(NotEnoughParameters e) {
        return ResponseEntity.badRequest().body("недостаточно параметров");
    }

    @RequestMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @RequestMapping("/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer a,
                       @RequestParam(name = "num2", required = false) Integer b)
            throws NotEnoughParameters {
        Integer result = calcService.plus(a, b);
        return a + " + " + b + " = " + result;
    }

    @RequestMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer a,
                        @RequestParam(name = "num2", required = false) Integer b)
            throws NotEnoughParameters {
        Integer result = calcService.minus(a, b);
        return a + " - " + b + " = " + result;
    }

    @RequestMapping("/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer a,
                           @RequestParam(name = "num2", required = false) Integer b)
            throws NotEnoughParameters {
        Integer result = calcService.multiply(a, b);
        return a + " * " + b + " = " + result;
    }

    @RequestMapping("/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer a,
                         @RequestParam(name = "num2", required = false) Integer b)
            throws DivisionByZeroException, NotEnoughParameters {
        Integer result = calcService.divide(a, b);
        return a + " / " + b + " = " + result;
    }
}

package com.example.homework211.services;

import org.springframework.http.ResponseEntity;

public interface CalcService {

    ResponseEntity<String> plus(Double a, Double b);

    ResponseEntity<String> minus(Double a, Double b);

    ResponseEntity<String> multiply(Double a, Double b);

    ResponseEntity<String> divide(Double a, Double b);
}

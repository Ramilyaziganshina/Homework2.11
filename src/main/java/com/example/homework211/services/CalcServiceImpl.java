package com.example.homework211.services;

import com.example.homework211.exceptions.DivisionByZeroException;
import com.example.homework211.exceptions.NotEnoughParameters;
import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {

    public Integer plus(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NotEnoughParameters();
        }
        return a + b;
    }

    public Integer minus(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NotEnoughParameters();
        }
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NotEnoughParameters();
        }
        return a * b;
    }

    public Integer divide(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NotEnoughParameters();
        } else if (b == 0) {
            throw new DivisionByZeroException();
        }
        return a / b;
    }
}

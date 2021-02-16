package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.NegativeNumException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator implements ICalculator {
    private Logger log = LoggerFactory.getLogger(Calculator.class);

    @Override
    public double sum(double a, double b) {
        log.info("A sum has been executed: " + a + " + " + b);
        return a + b;
    }

    @Override
    public double substract(double a, double b) {
        return a - b;
    }

    @Override
    public double division(double a, double b) {
        if (b == 0){
            throw new ArithmeticException("Can't divide by 0");
        } else {
            return a / b;
        }
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double neg(double a) {
        return -a;
    }

    @Override
    public int factorial(int a) throws NegativeNumException {
        if (a <= 0){
            throw new NegativeNumException();
        } else {
            int res = 1;
            for (int i = 1; i <= a; i++) {
                res *= i;
            }
            return res;
        }
    }
}

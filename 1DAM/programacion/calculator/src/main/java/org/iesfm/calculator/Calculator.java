package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.NegativeNumException;

public class Calculator implements ICalculator {

    @Override
    public double sum(double a, double b) {
        return a + b;
    }

    @Override
    public double substract(double a, double b) {
        return a - b;
    }

    @Override
    public double division(double a, double b) {
        return a / b;
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

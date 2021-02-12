package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.NegativeNumException;

public interface ICalculator {

    double sum(double a, double b);
    double substract (double a, double b);
    double division (double a, double b);
    double multiply (double a, double b);
    double neg (double a);
    int factorial (int a) throws NegativeNumException;
}

package org.iesfm.calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    private final static double DELTA = 0.001;

    @Test
    public void sumTest() {
        double a = 2;
        double b = 5;

        double res = calculator.sum(a, b);

        Assert.assertEquals(7, res, DELTA);
    }

    @Test
    public void sumNegativesTest() {
        double a = -2;
        double b = -5;

        double res = calculator.sum(a, b);

        Assert.assertEquals(-7, res, DELTA);
    }

    @Test
    public void substractTest() {
        double a = 2;
        double b = 5;

        double res = calculator.substract(a, b);

        Assert.assertEquals(-3, res, DELTA);
    }

    @Test
    public void substractNegativeAndPositiveTest() {
        double a = 2;
        double b = -5;

        double res = calculator.substract(a, b);

        Assert.assertEquals(7, res, DELTA);
    }

    @Test
    public void DivisionTest() {
        double a = 2;
        double b = 5;

        double res = calculator.division(a, b);

        Assert.assertEquals(0.4, res, DELTA);
    }

    @Test
    public void DivisionNegativeAndPositive() {
        double a = 2;
        double b = -5;

        double res = calculator.division(a, b);

        Assert.assertEquals(-0.4, res, DELTA);
    }

    @Test
    public void DivisionBy0() {
        double a = 2;
        double b = 0;
    }
}

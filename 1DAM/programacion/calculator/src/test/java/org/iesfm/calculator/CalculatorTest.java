package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.NegativeNumException;
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
    public void divisionTest() {
        double a = 2;
        double b = 5;

        double res = calculator.division(a, b);

        Assert.assertEquals(0.4, res, DELTA);
    }

    @Test
    public void divisionNegativeAndPositive() {
        double a = 2;
        double b = -5;

        double res = calculator.division(a, b);

        Assert.assertEquals(-0.4, res, DELTA);
    }

    @Test (expected = ArithmeticException.class)
    public void divisionBy0Test() throws ArithmeticException{
        double a = 2;
        double b = 0;

        calculator.division(a, b);
    }

    @Test
    public void division0By0Test() {
        double a = 0;
        double b = 0;

        double res = calculator.division(a, b);

        Assert.assertTrue(Double.isNaN(res));
    }

    @Test
    public void multiplyTest() {
        double a = 2;
        double b = 5;

        double res = calculator.multiply(a, b);

        Assert.assertEquals(10, res, DELTA);
    }

    @Test
    public void multiplyNegativeTest() {
        double a = -2;
        double b = 5;

        double res = calculator.multiply(a, b);

        Assert.assertEquals(-10, res, DELTA);
    }

    @Test
    public void multiplyNegativeByNegative() {
        double a = -2;
        double b = -5;

        double res = calculator.multiply(a, b);

        Assert.assertEquals(10, res, DELTA);
    }

    @Test
    public void multiplyBy0() {
        double a = 2;
        double b = 0;

        double res = calculator.multiply(a, b);

        Assert.assertEquals(0, res, DELTA);
    }

    @Test
    public void negTest() {
        double a = 2;

        double res = calculator.neg(a);

        Assert.assertEquals(-2, res, DELTA);
    }

    @Test
    public void negNegativeTest() {
        double a = -2;

        double res = calculator.neg(a);

        Assert.assertEquals(2, res, DELTA);
    }

    @Test
    public void factorialTest() {
        int a = 3;

        try {
            int res = calculator.factorial(a);
            Assert.assertEquals(6, res);
        } catch (NegativeNumException e) {
            Assert.fail("No deberia dar una excepcion ya que no hay negativos");
        }
    }

    @Test
    public void factorialNegativeTest() {
        int a = -3;

        try {
            int res = calculator.factorial(a);
            Assert.fail("Deberia dar una excepcion ya que hay negativos");
        } catch (NegativeNumException e){

        }
    }
}

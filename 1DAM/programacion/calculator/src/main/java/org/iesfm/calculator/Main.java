package org.iesfm.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double sum = calculator.sum(1, 2);

        log.info("The result is: " + sum);
    }
}

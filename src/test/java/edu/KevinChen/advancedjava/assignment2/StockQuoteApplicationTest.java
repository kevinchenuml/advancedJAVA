package edu.KevinChen.advancedjava.assignment2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit tests for the StockQuoteApplication class
 *
 * @author Kevin Chen
 */

public class StockQuoteApplicationTest {

    @Test
    public void testMain() {
        StockQuoteApplication.main(new String[] {"test1"});
    }

    /**
     * Negative Test
    @Test(expected = NullPointerException.class)
    public void testMainNegative() {
        StockQuoteApplication.main(null);
    }
    **/
}

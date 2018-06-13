package edu.KevinChen.advancedjava.assignment2;

import edu.KevinChen.advancedjava.assignment2.StockQuote;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * JUnit tests for the BasicStockService class
 *
 * @author Kevin Chen
 */

public class StockQuoteTest {

    private double StockPrice;
    private String StockSymbol;
    private double testPrice;
    private Calendar stockDate;

    @Before
    public void setup() {
        StockPrice = 100.00;
        testPrice = 100.00;
        StockSymbol = "Basic";
        stockDate = Calendar.getInstance();
    }

    @Test
    public void testStockQuoteConstruction() {
        StockQuote stockQuote = new StockQuote(StockPrice, StockSymbol, stockDate);

        assertEquals("The Price is Correct", stockQuote.getStockPrice(),  testPrice, 0.0002);
        assertEquals("The Symbol is correct", stockQuote.getStockSymbol(), "Basic");

    }
}

package edu.KevinChen.advancedjava.assignment2;

import edu.KevinChen.advancedjava.assignment2.BasicStockService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit tests for the BasicStockService class
 *
 * @author Kevin Chen
 */

public class BasicStockServiceTest {

    private String basic;

    @Before
    public void setup() {
        basic = "Basic";
    }

    @Test
    public void testBasicStockService() {
        BasicStockService basicStockService = new BasicStockService();
        basicStockService.getQuote(basic);
        assertEquals("The Symbol is correct", basicStockService.getQuote(basic).getStockSymbol(), "Basic");
    }
}

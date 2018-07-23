package edu.KevinChen.advancedjava.assignment7.util;

import edu.KevinChen.advancedjava.assignment7.services.StockQuoteServiceException;
import edu.KevinChen.advancedjava.assignment7.services.StockService;
import edu.KevinChen.advancedjava.assignment7.services.StockServiceFactory;
import org.junit.Test;
import yahoofinance.Stock;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>activitiesService</CODE>
 */
public class StockServiceFactoryTest {

    @Test
    public void testFactory() throws StockQuoteServiceException {
        Stock instance = StockServiceFactory.getStockQuoteFromApi("GOOG");
        assertNotNull("Make sure factory works", instance);
    }
}

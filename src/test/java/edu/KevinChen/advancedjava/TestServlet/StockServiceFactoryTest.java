package edu.KevinChen.advancedjava.TestServlet;

import service.StockServiceException;
import service.StockServiceFactory;
import org.junit.Test;
import yahoofinance.Stock;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>activitiesService</CODE>
 */
public class StockServiceFactoryTest {

    @Test
    public void testFactory() throws StockServiceException {
        Stock instance = StockServiceFactory.getStockQuoteFromApi("GOOG");
        assertNotNull("Make sure factory works", instance);
    }
}

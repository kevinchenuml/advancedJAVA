package edu.KevinChen.advancedjava.assignment7.util;

import edu.KevinChen.advancedjava.assignment7.services.StockService;
import edu.KevinChen.advancedjava.assignment7.services.StockServiceFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>activitiesService</CODE>
 */
public class StockServiceFactoryTest {

    @Test
    public void testFactory() {
        StockService instance = StockServiceFactory.getInstance();
        assertNotNull("Make sure factory works", instance);
    }
}

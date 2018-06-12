package edu.KevinChen.advancedjava.assignment2;

import edu.KevinChen.advancedjava.assignment2.StockServiceFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockServiceFactoryTest {

    private String QuoteSymbol;

    @Before
    public void setup() {
        QuoteSymbol = "Basic";
    }

    @Test
    public void testStockServiceFactory() {
        StockServiceFactory stockServiceFactory = new StockServiceFactory();


        assertEquals("The Factory creates a new quote with correct symbol", stockServiceFactory.getStockQuote().getQuote(QuoteSymbol).getStockSymbol(), "Basic");
    }

}

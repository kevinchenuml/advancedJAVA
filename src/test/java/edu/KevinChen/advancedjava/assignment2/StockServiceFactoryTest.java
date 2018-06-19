package edu.KevinChen.advancedjava.assignment2;

import edu.KevinChen.advancedjava.assignment2.StockServiceFactory;
import org.apache.http.annotation.Immutable;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

@Immutable
public class StockServiceFactoryTest {

    private String QuoteSymbol;

    @Before
    public void setup() {
        QuoteSymbol = "Basic";
        Calendar from = Calendar.getInstance();
        Calendar until = Calendar.getInstance();
        until.add(Calendar.DATE, 2);

    }

    @Test
    @NotNull
    public void testStockServiceFactory() {
        StockServiceFactory stockServiceFactory = new StockServiceFactory();


        assertEquals("The Factory creates a new quote with correct symbol", stockServiceFactory.getStockQuote().getQuote(QuoteSymbol).getStockSymbol(), "Basic");
    }

}

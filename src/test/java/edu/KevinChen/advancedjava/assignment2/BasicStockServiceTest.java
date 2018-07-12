package edu.KevinChen.advancedjava.assignment2;


import org.apache.http.annotation.Immutable;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * JUnit tests for the BasicStockService class
 *
 * @author Kevin Chen
 */

@Immutable
public class BasicStockServiceTest {

    private String basic;
    private Calendar until;
    private Calendar after;
    private IntervalEnum intervalEnum;

    @Before
    public void setup() {
        basic = "Basic";
        until = Calendar.getInstance();
        after = Calendar.getInstance();
        after.add(Calendar.DATE, 1);
        intervalEnum = IntervalEnum.Daily;
    }

    @Test
    @NotNull
    public void testBasicStockService() {
        BasicStockService basicStockService = new BasicStockService();
        basicStockService.getQuote(basic, until, after, intervalEnum);
        assertEquals("The Symbol is correct", basicStockService.getQuote(basic).getStockSymbol(), "Basic");
    }
}

package edu.KevinChen.advancedjava.TestServlet;

import com.origami.teach.model.StockQuote;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit test for the Person class
 */
public class StockQuoteTest {

    public  static final Calendar birthDayCalendar = Calendar.getInstance();

    static {
        birthDayCalendar.set(1990, Calendar.JANUARY, 12);
    }

    public static final String Symbol = "Spencer";
    public  static final String Price = "100.00";
    public static final Timestamp time = new Timestamp(birthDayCalendar.getTimeInMillis());

    /**
     * Testing helper method for generating Person test data
     *
     * @return a Person object that uses static constants for data.
     */
    public static StockQuote createStockQuote() {
        StockQuote stockQuote = new StockQuote();
        stockQuote.setSymbol(Symbol);
        stockQuote.setPrice(Price);
        stockQuote.setTime(time);
        return stockQuote;
    }

    @Test
    public void testStockQuoteGettersAndSetters() {
        StockQuote stockQuote = createStockQuote();
        int id = 10;
        stockQuote.setId(id);
        assertEquals("first name matches", Symbol, stockQuote.getSymbol());
        assertEquals("Price matches", Price, stockQuote.getPrice());
        assertEquals("time matches", time, stockQuote.getTime());
        assertEquals("id matches", id, stockQuote.getId());

    }

}

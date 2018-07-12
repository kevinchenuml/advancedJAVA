package edu.KevinChen.advancedjava.assignment7.util;

import edu.KevinChen.advancedjava.assignment7.model.StockQuote;
import edu.KevinChen.advancedjava.assignment7.services.StockService;
import edu.KevinChen.advancedjava.assignment7.services.StockQuoteServiceException;
import edu.KevinChen.advancedjava.assignment7.services.StockServiceFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the DatabaseActivitiesService
 */
public class DatabaseActivitiesServiceTest {

    private StockService stockService;

    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    // do not assume db is correct
    @Before
    public void setUp() throws Exception {
        // we could also copy db state here for later restore before initializing
        initDb();
        stockService = StockServiceFactory.getInstance();
    }

    // clean up after ourselves. (this could also restore db from initial state
    @After
    public void tearDown() throws Exception {
        initDb();
    }

    @Test
    public void testGetInstance() {
        assertNotNull("Make sure activitiesService is available", stockService);
    }

    @Test
    public void testGetPerson() throws StockQuoteServiceException {
        List<StockQuote> personList = stockService.getStockQuote();
        assertFalse("Make sure we get some Person objects from service", personList.isEmpty());
    }

    @Test
    public void testAddOrUpdatePerson()throws StockQuoteServiceException {
        StockQuote newStock = StockQuoteTest.createStockQuote();
        stockService.addOrUpdateStockQuote(newStock);
        List<StockQuote> stockQuoteList = stockService.getStockQuote();
        boolean found = false;
        for (StockQuote stockQuote : stockQuoteList) {
            Timestamp returnedBirthDate = stockQuote.getTime();
            Calendar returnCalendar = Calendar.getInstance();
            returnCalendar.setTimeInMillis(returnedBirthDate.getTime());
            if (returnCalendar.get(Calendar.MONTH) == StockQuoteTest.birthDayCalendar.get(Calendar.MONTH)
                    &&
                    returnCalendar.get(Calendar.YEAR) == StockQuoteTest.birthDayCalendar.get(Calendar.YEAR)
                    &&
                    returnCalendar.get(Calendar.DAY_OF_MONTH) == StockQuoteTest.birthDayCalendar.get(Calendar.DAY_OF_MONTH)
                    &&
                    stockQuote.getSymbol().equals(StockQuoteTest.Symbol)
                    &&
                    stockQuote.getPrice().equals(StockQuoteTest.Price)) {
                found = true;
                break;
            }
        }
        assertTrue("Found the person we added", found);
    }

}


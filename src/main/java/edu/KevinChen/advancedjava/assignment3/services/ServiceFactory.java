package edu.KevinChen.advancedjava.assignment3.services;

import edu.KevinChen.advancedjava.assignment3.model.StockQuote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A factory that returns a <CODE>StockService</CODE> instance.
 */
public class ServiceFactory {

    /**
     * Prevent instantiations
     */
    private ServiceFactory() {}

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getStockServiceInstance() {
        return new DatabaseStockService() {
            @Override
            public StockQuote getQuote(String symbol) throws StockServiceException {
                return new StockQuote(new BigDecimal(100), Calendar.getInstance().getTime(), symbol);
            }

            @Override
            public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) throws StockServiceException {
                List<StockQuote> stockQuotes = new ArrayList<>();
                Date aDay = from.getTime();
                while (until.after(aDay))  {
                    stockQuotes.add(new StockQuote(new BigDecimal(100),aDay,symbol));
                    from.add(Calendar.DAY_OF_YEAR, 1);
                    aDay = from.getTime();
                }
                return stockQuotes;            }
        };
    }

    public static PersonService getPersonServiceInstance() {
        return new DatabasePersonService();
    }

}

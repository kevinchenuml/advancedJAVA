package edu.KevinChen.advancedjava.assignment2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BasicStockService implements StockService {

    /**
     * Return the current price for a share of stock for the given symbol
     * @param Basic the stock symbol of the company you want a quote for.
     * e.g. APPL for APPLE
     * @return a <CODE>StockQuote </CODE> instance
     */
    public StockQuote getQuote(String Basic) {
        Calendar cal = Calendar.getInstance();

        StockQuote stockQuote = new StockQuote(100.00, Basic, cal);
        return stockQuote;
    }
    /**
     * Return the current prices for a share of stock for the given symbol and date range
     * @param symbol the stock symbol of the company you want a quote for.
     * @param from the start date
     * @param until the end date
     * @return a <CODE>List<StockQuote></CODE> instance
     */
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {
        List<StockQuote> list = new ArrayList<StockQuote>();
        list.add(new StockQuote(90.00, symbol, from));
        from.add(Calendar.DATE, 1);
        list.add(new StockQuote(80.00, symbol, from));
        list.add(new StockQuote(70.00, symbol, until));
        return list;
    }

}

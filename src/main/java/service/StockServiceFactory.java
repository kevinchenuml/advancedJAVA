package service;

import com.origami.teach.model.StockQuote;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/**
 * A factory that returns a <CODE>StockService</CODE> instance.
 */
public class StockServiceFactory {

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getInstance() {
        return new DatabaseStockService() {
            @Override
            public StockQuote getQuote(String symbol) throws StockServiceException {
                StockQuote stockQuote = new StockQuote();
                stockQuote.setSymbol(symbol);
                stockQuote.setPrice("100.00");
                stockQuote.setTime(Calendar.getInstance().getTime());
                return stockQuote;
            }

            @Override
            public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) throws StockServiceException {
                List<StockQuote> stockQuotes = new ArrayList<>();
                Date aDay = from.getTime();
                while (until.after(aDay))  {
                    StockQuote stockQuote = new StockQuote();
                    stockQuote.setSymbol(symbol);
                    stockQuote.setPrice("100.00");
                    stockQuote.setTime(aDay);
                    stockQuotes.add(stockQuote);
                    from.add(Calendar.DAY_OF_YEAR, 1);
                    aDay = from.getTime();
                }
                return stockQuotes;            }
        };
    }

    /**
     * Get a stock from web API
     *
     * @return a stock
     */
    public static Stock getStockQuoteFromApi(String Symbol) throws StockServiceException {

        Stock stock = null;

        try {
            stock = YahooFinance.get(Symbol);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stock;
    }

}

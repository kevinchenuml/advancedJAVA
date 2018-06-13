package edu.KevinChen.advancedjava.assignment2;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * This class contains information about a stock.
 */

public class StockQuote {
    private String stockSymbol;
    private double stockPrice;
    private Calendar stockDate;

    /**
     *  Create a new  StockData instance
     * @param stockPrice the price of the stock for the provided date
     * @param stockSymbol the stock symbol e.g. APPL (for APPLE)
     */

    public StockQuote(double stockPrice, String stockSymbol, Calendar stockDate) {

        this.stockPrice = stockPrice;
        this.stockSymbol = stockSymbol;
        this.stockDate = stockDate;
    }

    /**
     *
     * @return the symbol that represents the company whose stock this is.
     */
    public String getStockSymbol() { return stockSymbol;}

    /**
     *
     * @return The price of one share of stock.
     */
    public double getStockPrice() { return stockPrice;}

    /**
     *
     * @return The Date of the stock.
     */
    public Calendar getStockDate() { return stockDate;}
}

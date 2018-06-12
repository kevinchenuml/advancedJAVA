package edu.KevinChen.advancedjava.assignment2;
import java.math.BigDecimal;

/**
 * This class contains information about a stock.
 */

public class StockQuote {
    private String stockSymbol;
    private double stockPrice;

    /**
     *  Create a new  StockData instance
     * @param stockPrice the price of the stock for the provided date
     * @param stockSymbol the stock symbol e.g. APPL (for APPLE)
     */

    public StockQuote(double stockPrice, String stockSymbol) {

        this.stockPrice = stockPrice;
        this.stockSymbol = stockSymbol;
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

}

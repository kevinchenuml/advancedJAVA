package edu.KevinChen.advancedjava.assignment2;

/**
 *This class returns a concrete implementation of the interface StockService
 *
 */

public class StockServiceFactory {

    public static StockService getStockQuote() {
        return new BasicStockService();
    }

}

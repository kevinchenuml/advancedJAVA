package edu.KevinChen.advancedjava.assignment2;


import org.apache.http.annotation.Immutable;

/**
 *This class returns a concrete implementation of the interface StockService
 *
 */
@Immutable
public class StockServiceFactory {

    public static StockService getStockQuote() {
        return new BasicStockService();
    }

}

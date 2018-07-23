package edu.KevinChen.advancedjava.assignment7.services;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

public class StockServiceFactory {


    /**
     * Get a stock from web API
     *
     * @return a stock
     */
    public static Stock getStockQuoteFromApi(String Symbol) throws StockQuoteServiceException {

        Stock stock = null;

        try {
            stock = YahooFinance.get(Symbol);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stock;
    }

}

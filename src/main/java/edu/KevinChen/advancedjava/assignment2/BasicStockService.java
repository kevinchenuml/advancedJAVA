package edu.KevinChen.advancedjava.assignment2;

public class BasicStockService implements StockService {


    public StockQuote getQuote(String Basic) {
        StockQuote stockQuote = new StockQuote(100.00, Basic);
        return stockQuote;
    }

}

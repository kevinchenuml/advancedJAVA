package edu.KevinChen.advancedjava.assignment2;

import java.util.Calendar;

public class StockQuoteApplication {

    public static void main(String[] args) {

        StockServiceFactory stockServiceFactory = new StockServiceFactory();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DATE, 1);


        StockQuote stockQuote1;
        StockQuote stockQuote2;
        StockQuote stockQuote3;

        stockQuote1 = stockServiceFactory.getStockQuote().getQuote("APP", calendar, calendar2).get(0);
        stockQuote2 = stockServiceFactory.getStockQuote().getQuote("APP", calendar, calendar2).get(1);
        stockQuote3 = stockServiceFactory.getStockQuote().getQuote("APP", calendar, calendar2).get(2);

        System.out.println("Date: " + stockQuote1.getStockDate().getTime() + " " + stockQuote1.getStockPrice());
        System.out.println("Date: " + stockQuote2.getStockDate().getTime() + " " + stockQuote2.getStockPrice());
        System.out.println("Date: " + stockQuote3.getStockDate().getTime() + " " + stockQuote3.getStockPrice());
    }
}

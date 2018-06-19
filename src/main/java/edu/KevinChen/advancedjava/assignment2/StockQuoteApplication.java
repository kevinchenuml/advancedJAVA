package edu.KevinChen.advancedjava.assignment2;


import org.apache.http.annotation.Immutable;

import java.util.Calendar;

/**
 * This class is an application demonstrating the use of the Stock Factory
 */

@Immutable
public class StockQuoteApplication {

    /**
     *  Create a new StockServiceFactory
     */

    public static void main(String[] args) {

        StockServiceFactory stockServiceFactory = new StockServiceFactory();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DATE, 1);
        IntervalEnum intervalEnum = IntervalEnum.Daily;


        StockQuote stockQuote1;
        StockQuote stockQuote2;
        StockQuote stockQuote3;

        stockQuote1 = stockServiceFactory.getStockQuote().getQuote("APP", calendar, calendar2, intervalEnum).get(0);
        stockQuote2 = stockServiceFactory.getStockQuote().getQuote("APP", calendar, calendar2, intervalEnum).get(1);
        stockQuote3 = stockServiceFactory.getStockQuote().getQuote("APP", calendar, calendar2, intervalEnum).get(2);

        System.out.println("Date: " + stockQuote1.getStockDate().getTime() + " " + stockQuote1.getStockPrice());
        System.out.println("Date: " + stockQuote2.getStockDate().getTime() + " " + stockQuote2.getStockPrice());
        System.out.println("Date: " + stockQuote3.getStockDate().getTime() + " " + stockQuote3.getStockPrice());
        System.out.println("Interval" + intervalEnum);
    }
}

package edu.KevinChen.advancedjava.assignment7.services;

/**
 * A factory that returns a <CODE>ActivitiesService</CODE> instance.
 */
public class StockServiceFactory {

    /**
     * Prevent instantiations
     */
    private StockServiceFactory() {}

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getInstance() {
        return new DatabaseStockService();
    }

}

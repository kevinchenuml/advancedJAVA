package edu.KevinChen.advancedjava.assignment7.services;

import edu.KevinChen.advancedjava.assignment7.model.StockQuote;
import edu.KevinChen.advancedjava.assignment7.services.StockQuoteServiceException;

import java.util.List;

/**
 *
 */
public interface StockService {

    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     * @throws StockQuoteServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<StockQuote> getStockQuote() throws StockQuoteServiceException;

    /**
     * Add a new person or update an existing Person's data
     *
     * @param stockQuote a person object to either update or create
     * @throws StockQuoteServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    void addOrUpdateStockQuote(StockQuote stockQuote) throws StockQuoteServiceException;

}

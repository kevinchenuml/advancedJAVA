package edu.KevinChen.advancedjava.assignment7.services;

import edu.KevinChen.advancedjava.assignment7.model.StockQuote;
import edu.KevinChen.advancedjava.assignment7.util.DatabaseUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DatabaseStockService implements StockService {


    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<StockQuote> getStockQuote() throws StockQuoteServiceException{
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<StockQuote> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(StockQuote.class);

            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            returnValue = criteria.list();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockQuoteServiceException("Could not get StockQuote data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue;

    }

    /**
     * Add a new StockQuote or update an existing Stock Quote's data
     *
     * @param stockQuote a stockquote object to either update or create
     */
    @Override
    public void addOrUpdateStockQuote(StockQuote stockQuote) {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(stockQuote);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }

}


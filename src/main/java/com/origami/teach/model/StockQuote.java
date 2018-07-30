package com.origami.teach.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * A container class that contains stock data.
 */
public class StockQuote extends StockData {

    private String price;
    private Date time;
    private String symbol;
    //private Timestamp time;
    private int id;

    /**
     * Create a new instance of a StockQuote.
     *
     * @param price  the share price for the given date
     * @param date   the date of the share price
     * @param symbol the stock symbol.
     */

    /**
     * Primary Key - Unique ID for a particular row in the person table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the person table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Get the share price for the given date.
     */
    public String getPrice() {
        return price;
    }

    /**
     * Specify the stock price
     * @param price a String value
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return The date of the share price
     */
    public Date getDate() {
        return time;
    }

    /**
     * @return The stock symbol.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Specify the stock symbol
     * @param symbol a String value
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @return the person's last name
     */
    @Basic
    @Column(name = "time", nullable = false, insertable = true, updatable = true, length = 256)
    public Date getTime() {
        return time;
    }

    /**
     * Specify the stock time
     * @param time a String value
     */
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        String dateString = simpleDateFormat.format(time);
        return "StockQuote{" +
                "price=" + price +
                ", date=" + dateString +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}

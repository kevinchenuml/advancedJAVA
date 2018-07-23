package edu.KevinChen.advancedjava.assignment7.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Models the Person table
 */
@Entity
@Table(name="quotes")
public class StockQuote {

    private int id;
    private String symbol;
    private Timestamp time;
    private String price;


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
     *
     * @return the stock symbol
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 256)
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
    public Timestamp getTime() {
        return time;
    }

    /**
     * Specify the stock time
     * @param time a String value
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     *
     * @return the stock price
     */
    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true, length = 256)
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockQuote stockQuote = (StockQuote) o;

        if (id != stockQuote.id) return false;
        if (symbol != null ? !symbol.equals(stockQuote.symbol) : stockQuote.symbol != null)
            return false;
        if (time != null ? !time.equals(stockQuote.time) : stockQuote.time != null)
            return false;
        if (price != null ? !price.equals(stockQuote.price) : stockQuote.price != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "StockQuote{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", time='" + time + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
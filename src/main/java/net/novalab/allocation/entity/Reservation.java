package net.novalab.allocation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Date;
import java.util.Objects;

/**
 * Created by gsoo on 23/08/2017.
 */
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "reservation.from", query = "select r from Reservation r where r.date >= :date and r.source = :factory")
}
)

public class Reservation {

    @Id
    private long code;
    private String product;
    private String customer;
    private String source;
    private double qty;
    private Date date;
    private Date orderDate;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return code == that.code &&
                Double.compare(that.qty, qty) == 0 &&
                Objects.equals(product, that.product) &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(source, that.source) &&
                Objects.equals(date, that.date) &&
                Objects.equals(orderDate, that.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, product, customer, source, qty, date, orderDate);
    }
}

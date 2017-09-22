package net.novalab.reservation.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by gsoo on 23/08/2017.
 */
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "reservation.from", query = "select r from Reservation r where r.date >= :date")
}
)

public class Reservation {

    @Id
    private long code;
    private String product;
    private String customer;
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
                Objects.equals(date, that.date) &&
                Objects.equals(orderDate, that.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, product, customer, qty, date, orderDate);
    }
}

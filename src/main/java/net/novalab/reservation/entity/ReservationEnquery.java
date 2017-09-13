package net.novalab.reservation.entity;

import net.novalab.product.entity.Product;

import java.util.*;

/**
 * Created by Omer on 24.8.2017.
 */
public class ReservationEnquery {

    private Product product;
    private Map<Date, Double> dateQtyMap;

    public ReservationEnquery(){
        dateQtyMap = new HashMap<>();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Map<Date, Double> getDateQtyMap() {
        return dateQtyMap;
    }

    public void setDateQtyMap(Map<Date, Double> dateQtyMap) {
        this.dateQtyMap = dateQtyMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEnquery that = (ReservationEnquery) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(dateQtyMap, that.dateQtyMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, dateQtyMap);
    }
}

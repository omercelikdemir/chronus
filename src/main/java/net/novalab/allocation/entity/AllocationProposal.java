package net.novalab.allocation.entity;

import java.util.Date;
import java.util.Map;

public class AllocationProposal {

    private String factory;
    private String product;
    private double quantity;
    private Date date;

    public AllocationProposal(String factory, String product, double quantity, Date date) {
        this.factory = factory;
        this.product = product;
        this.quantity = quantity;
        this.date = date;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

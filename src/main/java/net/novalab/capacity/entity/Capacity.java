package net.novalab.capacity.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Entity
public class Capacity {

    @Id
    private String source;
    @NotNull
    private Date time;
    @DecimalMin("0")
    private double quantity;
    private int priority;
    @CollectionTable
    @MapKeyColumn(name = "product")
    @Column(name = "quantity")
    @ElementCollection
    private Map<String, Double> capacities;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Map<String, Double> getCapacities() {
        return capacities;
    }

    public void setCapacities(Map<String, Double> capacities) {
        this.capacities = capacities;
    }
}

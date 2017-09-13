package net.novalab.capacity.entity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Capacity {

    private int numberOfDays;
    private long duration;


    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capacity capacity = (Capacity) o;
        return numberOfDays == capacity.numberOfDays &&
                duration == capacity.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfDays, duration);
    }
}

package net.novalab.capacity.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Capacity {

    @Id
    private String factory;
    private long duration;

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
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
        return duration == capacity.duration &&
                Objects.equals(factory, capacity.factory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factory, duration);
    }
}

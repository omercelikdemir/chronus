package net.novalab.capacity.control;

import net.novalab.capacity.entity.Capacity;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.*;

public class CapacityFinder {
    @Inject
    Instance<CapacityResource> instance;

    private String source;

    CapacityFinder from(String source) {
        this.source = source;
        return this;
    }


    public Set<Set<Capacity>> loadCapacities() {
        Set<Set<Capacity>> capacities = new TreeSet<>();
        instance.forEach(r -> capacities.add(r.getCapacities(this.source, new Date())));
        return capacities;
    }


}

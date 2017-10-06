package net.novalab.capacity.control;

import net.novalab.capacity.entity.Capacity;

import java.util.Date;
import java.util.Set;

public interface CapacityResource {


    Set<Capacity> getCapacities(String source, Date from);
}

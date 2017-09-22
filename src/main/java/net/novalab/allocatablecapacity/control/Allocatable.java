package net.novalab.allocatablecapacity.control;

import net.novalab.allocatablecapacity.entity.AllocatableCapacity;

public interface Allocatable  {

    AllocatableCapacity findAllocatableCapacity(String factory, String productCode, double quantity);
}

package net.novalab.filters.control;

import net.novalab.allocatablecapacity.control.Allocatable;
import net.novalab.allocatablecapacity.entity.AllocatableCapacity;
import net.novalab.filters.entity.Constraint;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Priority(1)
@Decorator
public class CustomerFilter implements Allocatable {

    @Inject
    private Constraint constraint;

    @Inject
    @Delegate
    private Allocatable allocatable;

    @Override
    public AllocatableCapacity findAllocatableCapacity(String productCode, double quantity) {
        AllocatableCapacity allocatableCapacity = allocatable.findAllocatableCapacity(productCode, quantity);
        // do stuff
        return allocatableCapacity;
    }
}

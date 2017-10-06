package net.novalab.filters.control;

import net.novalab.allocation.control.Allocatable;
import net.novalab.allocation.entity.AllocationProposal;
import net.novalab.filters.entity.Constraint;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Priority(1)
@Decorator
public class CustomerFilter implements Allocatable{

    @Inject
    private Constraint constraint;

    @Inject
    @Delegate
    private Allocatable allocatable;

    @Override
    public AllocationProposal allocate(String product, double quantity) {
        // do some filtering stuff
        return null;
    }
}

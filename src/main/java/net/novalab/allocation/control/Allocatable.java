package net.novalab.allocation.control;

import net.novalab.allocation.entity.AllocationProposal;

public interface Allocatable {
    AllocationProposal allocate(String product, double quantity);
}

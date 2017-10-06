package net.novalab.allocation.control;

import net.novalab.allocation.entity.Allocation;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class AllocationHandler {

    @Inject
    EntityManager em;

    public Allocation createAllocationOn(String factory, String product, Double quantity, Date allocationTime) {
        Allocation allocation = new Allocation(factory, allocationTime);
        allocation.addAllocation(product, quantity);
        em.persist(allocation);
        em.flush();
        em.refresh(allocation);
        return allocation;
    }

    public List<Allocation> getAllocations() {
        return em.createNamedQuery(Allocation.ALLOCATIONS_FROM)
                .setParameter(1, new Date())
                .getResultList();
    }
}

package net.novalab.allocation.control;

import net.novalab.allocation.entity.Allocation;
import net.novalab.allocation.entity.AllocationProposal;
import net.novalab.allocation.entity.Reservation;
import net.novalab.capacity.control.CapacityFinder;
import net.novalab.capacity.entity.Capacity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import java.util.Date;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;

public class CapacityAllocator implements Allocatable {

    @Inject
    CapacityFinder capacityFinder;
    @Inject
    AllocationHandler allocationHandler;

    @Inject
    EntityManager em;

    @Override
    public AllocationProposal allocate(String product, double quantity) {
        Set<Set<Capacity>> capacities = capacityFinder.loadCapacities();
        List<Allocation> allocations = allocationHandler.getAllocations();

        // do some stuff
        return null;
    }

    public void makeReservation(String customer, AllocationProposal proposal) {
        try {
            allocationHandler.createAllocationOn(proposal.getFactory(), proposal.getProduct(), proposal.getQuantity(), proposal.getDate());
            Reservation reservation = new Reservation();
            reservation.setProduct(proposal.getProduct());
            reservation.setDate(proposal.getDate());
            reservation.setQty(proposal.getQuantity());
            reservation.setSource(proposal.getFactory());
            reservation.setOrderDate(new Date());
            reservation.setCustomer(customer);
            em.persist(reservation);


        } catch (OptimisticLockException e) {
            // do stuff
        }
    }

}

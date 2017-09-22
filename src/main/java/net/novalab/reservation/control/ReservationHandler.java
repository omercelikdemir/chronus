package net.novalab.reservation.control;

import net.novalab.allocatablecapacity.control.Allocatable;
import net.novalab.allocatablecapacity.entity.AllocatableCapacity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by gsoo on 23/08/2017.
 */
@RequestScoped
public class ReservationHandler {


    @Inject
    private Allocatable allocatable;

    @PersistenceContext
    private EntityManager em;

    public Object find(String factory, String product, double qty) {
        AllocatableCapacity allocatableCapacity = allocatable.findAllocatableCapacity(factory, product, qty);
        return null;
    }



}

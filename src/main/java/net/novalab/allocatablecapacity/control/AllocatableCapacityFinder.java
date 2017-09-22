package net.novalab.allocatablecapacity.control;

import net.novalab.allocatablecapacity.entity.AllocatableCapacity;
import net.novalab.capacity.control.CapacityFinder;
import net.novalab.capacity.entity.Capacity;
import net.novalab.product.control.ProductFinder;
import net.novalab.product.entity.Product;
import net.novalab.reservation.control.ReservationFinder;
import net.novalab.reservation.entity.Reservation;

import javax.inject.Inject;
import java.util.Comparator;

public class AllocatableCapacityFinder implements Allocatable {

    @Inject
    ReservationFinder reservationFinder;
    @Inject
    CapacityFinder capacityFinder;
    @Inject
    ProductFinder productFinder;

    public AllocatableCapacity findAllocatableCapacity(String productCode, double quantity) {
        Capacity capacity = capacityFinder.findCapacity();
        Product product = productFinder.findProduct(productCode);
        double holdingCapacity = quantity / product.getCapacity();

        reservationFinder.getReservations().stream().sorted(Comparator.comparing(Reservation::getDate).thenComparing(Reservation::getCode));
        return null;
    }
}

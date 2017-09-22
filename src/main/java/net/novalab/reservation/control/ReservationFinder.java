package net.novalab.reservation.control;

import net.novalab.reservation.entity.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by Omer on 24.8.2017.
 */

public class ReservationFinder {
    @PersistenceContext
    EntityManager em;

    public Reservation find(String code) {
        return em.find(Reservation.class, code);
    }


    public NavigableSet<Reservation> getReservations() {
        Supplier<TreeSet<Reservation>> supplier = () -> new TreeSet<>(Comparator.comparing(Reservation::getOrderDate).thenComparing(Reservation::getCode));
        return em.createNamedQuery("reservation.from", Reservation.class).setParameter("name", new Date())
                .getResultList().stream().collect(Collectors.toCollection(supplier));
    }
}

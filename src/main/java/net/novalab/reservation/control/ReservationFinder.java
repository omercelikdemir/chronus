package net.novalab.reservation.control;

import net.novalab.reservation.entity.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Omer on 24.8.2017.
 */

public class ReservationFinder {
    @PersistenceContext
    EntityManager em;

    public Reservation find(String code) {
        return em.find(Reservation.class, code);
    }

    public List<Reservation> getAllReservationsFor(String customer) {
        return em.createNamedQuery("planning.reservation.forCustomer", Reservation.class).setParameter("customer", customer).getResultList();
    }
}

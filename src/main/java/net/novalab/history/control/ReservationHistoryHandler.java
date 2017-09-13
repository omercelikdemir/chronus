package net.novalab.history.control;

import net.novalab.reservation.control.ReservationFinder;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ReservationHistoryHandler {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private ReservationFinder reservationFinder;

    public void cancel(String reservation) {
        em.remove(reservationFinder.find(reservation));
    }

    public void cancel(List<String> reservations) {
        reservations.forEach(reservation -> em.remove(reservationFinder.find(reservation)));

    }
}

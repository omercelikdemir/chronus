package net.novalab.reservation.control;

import net.novalab.reservation.entity.ReservationEnquery;

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
    private ReservationEnquirer reservationEnquirer;

    @PersistenceContext
    private EntityManager em;

    public ReservationEnquery enquire(String product, double qty) {
        ReservationEnquery reservationEnquery = reservationEnquirer.enquire(product, qty);
        return reservationEnquery;
    }


    public void confirm() {
       /* List<Reservation> reservations = reservationEnquiryContext.getReservationEnquery().getDateQtyMap().entrySet().stream().map(e -> {
            Reservation reservation = new Reservation();
            reservation.setCustomer(context.getCustomer().getCode());
            reservation.setProduct(reservationEnquiryContext.getReservationEnquery().getProduct().getCode());
            reservation.setDate(e.getKey());
            reservation.setQty(e.getValue());
            return reservation;
        }).collect(Collectors.toList());
        reservations.forEach(r -> em.merge(r));*/
    }

}

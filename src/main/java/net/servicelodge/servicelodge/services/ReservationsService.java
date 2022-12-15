package net.servicelodge.servicelodge.services;

import net.servicelodge.servicelodge.models.Reservation;
import net.servicelodge.servicelodge.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsService
{
    private final ReservationRepository reservationDao;

    public ReservationsService(ReservationRepository reservationDao) {
        this.reservationDao = reservationDao;
    }

    public List<Reservation> getReservations()
    {
        return reservationDao.findAll();
    }
}

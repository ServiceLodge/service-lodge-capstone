package net.servicelodge.servicelodge.services;

import net.servicelodge.servicelodge.models.Drill;
import net.servicelodge.servicelodge.models.Reservation;
import net.servicelodge.servicelodge.models.User;
import net.servicelodge.servicelodge.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private static ReservationRepository reservationDao;

    public ReservationService(ReservationRepository reservationDao) {
        ReservationService.reservationDao = reservationDao;
    }

    public static List<Reservation> findAll(){
        return reservationDao.findAll();
    }

}

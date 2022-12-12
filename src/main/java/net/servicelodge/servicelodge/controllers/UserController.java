package net.servicelodge.servicelodge.controllers;

import net.servicelodge.servicelodge.models.Reservation;
import net.servicelodge.servicelodge.models.User;
import net.servicelodge.servicelodge.repositories.ReservationRepository;
import net.servicelodge.servicelodge.repositories.UserRepository;
import net.servicelodge.servicelodge.services.UnitService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {
    private ReservationRepository reservationDao;

    public UserController(ReservationRepository reservationDao) {
        this.reservationDao = reservationDao;
    }

    @GetMapping("/reservations/all")
    public String all(Model model){
        List<Reservation> reservations = reservationDao.findAllByUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("reservations", reservations);
        return "/reservations/readAll";
    }

    @GetMapping("/reservations/{id}")
    public String showReservation(@PathVariable long id, Model model) {
        Reservation reservation = reservationDao.findById(id);
        model.addAttribute("reservation", reservation);
        return "/reservations/readOne";
    }
}

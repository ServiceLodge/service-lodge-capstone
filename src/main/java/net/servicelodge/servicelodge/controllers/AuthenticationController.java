package net.servicelodge.servicelodge.controllers;

import net.servicelodge.servicelodge.models.Reservation;
import net.servicelodge.servicelodge.models.User;
import net.servicelodge.servicelodge.repositories.ReservationRepository;
import net.servicelodge.servicelodge.repositories.UserRepository;
import net.servicelodge.servicelodge.services.UnitService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    private final UserRepository userDao;
    private final ReservationRepository reservationDao;

    public AuthenticationController(UserRepository userDao, ReservationRepository reservationDao) {
        this.userDao = userDao;
        this.reservationDao = reservationDao;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        // logged-in user
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", loggedInUser);

        // upcoming reservation
        Reservation upcomingReservation = reservationDao.findFirstByDrillIdAndUser(1,loggedInUser );
        model.addAttribute("reservation", upcomingReservation);

        return "profile";
    }
}

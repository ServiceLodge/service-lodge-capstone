package net.servicelodge.servicelodge.controllers;

import net.servicelodge.servicelodge.models.Drill;
import net.servicelodge.servicelodge.models.Reservation;
import net.servicelodge.servicelodge.models.User;
import net.servicelodge.servicelodge.repositories.DrillRepository;
import net.servicelodge.servicelodge.repositories.ReservationRepository;
import net.servicelodge.servicelodge.repositories.UserRepository;
import net.servicelodge.servicelodge.services.UnitService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;
import java.util.Date;

@Controller
public class AuthenticationController {

    private final DrillRepository drillDao;
    private final ReservationRepository reservationDao;

    public AuthenticationController(DrillRepository drillDao, ReservationRepository reservationDao) {
        this.drillDao = drillDao;
        this.reservationDao = reservationDao;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        model.addAttribute("notifications", reservationDao.findAllByHotelIsNull().size());

        // logged-in user
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", loggedInUser);

        // upcoming reservation
        Date today = new java.sql.Date(System.currentTimeMillis());
        Drill upcomingDrill = drillDao.findFirstByDrillEndDateAfter(today);
        Reservation upcomingReservation = null;
        if (upcomingDrill != null){
            upcomingReservation = reservationDao.findFirstByDrillIdAndUser(upcomingDrill.getId(), loggedInUser);
        }

        model.addAttribute("drill", upcomingDrill);
        model.addAttribute("reservation", upcomingReservation);

        return "profile";
    }
}

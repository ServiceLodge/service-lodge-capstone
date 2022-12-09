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

@Controller
public class ProfileController {
    private UserRepository userDao;
    private UnitService unitService;
    private ReservationRepository reservationDao;

    public ProfileController(UserRepository userDao, ReservationRepository reservationDao, UnitService unitService) {
        this.userDao = userDao;
        this.reservationDao = reservationDao;
        this.unitService = unitService;

    }


    @GetMapping("/profile")
    public String profile(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", loggedInUser);
        Reservation upcomingReservation = reservationDao.findFirstByDrillIdAndUser(1,loggedInUser );
        model.addAttribute("reservation", upcomingReservation);
        System.out.println(upcomingReservation.getDrill().getName());

        return "profile";
    }
}

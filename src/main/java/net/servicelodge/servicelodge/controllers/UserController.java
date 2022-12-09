package net.servicelodge.servicelodge.controllers;

import net.servicelodge.servicelodge.models.Reservation;
import net.servicelodge.servicelodge.models.Unit;
import net.servicelodge.servicelodge.models.User;
import net.servicelodge.servicelodge.repositories.ReservationRepository;
import net.servicelodge.servicelodge.repositories.UnitRepository;
import net.servicelodge.servicelodge.repositories.UserRepository;
import net.servicelodge.servicelodge.services.UnitService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private UserRepository userDao;
    private UnitService unitService;
    private PasswordEncoder passwordEncoder;
    private ReservationRepository reservationDao;

    public UserController(UserRepository userDao, ReservationRepository reservationDao, UnitService unitService, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.reservationDao = reservationDao;
        this.unitService = unitService;
        this.passwordEncoder = passwordEncoder;

    }

    @GetMapping("/all")
    public String all(Model model){
        List<Reservation> reservations = reservationDao.findAllByUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("reservations", reservations);
        return "all";
    }
}

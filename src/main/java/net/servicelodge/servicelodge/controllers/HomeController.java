package net.servicelodge.servicelodge.controllers;

import net.servicelodge.servicelodge.models.Drill;
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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String home() {
            return "index";
    }

    @GetMapping("/about")
    public String about() { return "about"; }

}

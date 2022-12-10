package net.servicelodge.servicelodge.controllers;

import net.servicelodge.servicelodge.models.Drill;
import net.servicelodge.servicelodge.models.Hotel;
import net.servicelodge.servicelodge.models.Reservation;
import net.servicelodge.servicelodge.models.User;
import net.servicelodge.servicelodge.repositories.DrillRepository;
import net.servicelodge.servicelodge.repositories.HotelRepository;
import net.servicelodge.servicelodge.repositories.ReservationRepository;
import net.servicelodge.servicelodge.repositories.UserRepository;
import net.servicelodge.servicelodge.services.UnitService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    private final UserRepository userDao;
    private final HotelRepository hotelDao;
    private final DrillRepository drillDao;
    private final ReservationRepository resDao;
    private final UnitService unitService;
    private final PasswordEncoder passwordEncoder;

    public AdminController(UserRepository userDao, HotelRepository hotelDao,  DrillRepository drillDao, ReservationRepository resDao, UnitService unitService, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.hotelDao = hotelDao;
        this.drillDao = drillDao;
        this.resDao = resDao;
        this.unitService = unitService;
        this.passwordEncoder = passwordEncoder;
    }

    ////////// USER CRUD //////////

    @GetMapping("/users/create")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("units", unitService.getUnits());
        return "users/create";
    }

    @PostMapping("/users/create")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    ////////// HOTEL CRUD //////////

    @GetMapping("/hotels/create")
    public String showHotelForm(Model model){
        model.addAttribute("hotel", new Hotel());
        return "hotels/create";
    }

    @PostMapping("/hotels/create")
    public String saveHotel(@ModelAttribute Hotel hotel){
        hotelDao.save(hotel);
        return "redirect:/profile";
    }

    ////////// DRILL CRUD //////////

    @GetMapping("/drills/create")
    public String showDrillForm(Model model){
        model.addAttribute("drill", new Drill());
        return "drills/create";
    }

    @PostMapping("/drills/create")
    public String saveDrill(@ModelAttribute Drill drill){
        drillDao.save(drill);
        return "redirect:/profile";
    }

    ////////// RESERVATION CRUD //////////

    @GetMapping("/reservations/create")
    public String showReservationForm(Model model){
        model.addAttribute("reservation", new Reservation());
        return "reservations/create";
    }

    @PostMapping("/reservations/create")
    public String saveReservation(@ModelAttribute Reservation reservation){
        resDao.save(reservation);
        return "redirect:/profile";
    }
}

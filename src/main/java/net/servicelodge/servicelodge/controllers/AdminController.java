package net.servicelodge.servicelodge.controllers;

import net.servicelodge.servicelodge.models.*;
import net.servicelodge.servicelodge.repositories.*;
import net.servicelodge.servicelodge.services.UnitService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    private final UserRepository userDao;
    private final HotelRepository hotelDao;
    private final DrillRepository drillDao;

    private final WingRepository wingDao;
    private final ReservationRepository resDao;
    private final UnitService unitService;
    private final PasswordEncoder passwordEncoder;

    public AdminController(UserRepository userDao, HotelRepository hotelDao,  DrillRepository drillDao, WingRepository wingDao, ReservationRepository resDao, UnitService unitService, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.hotelDao = hotelDao;
        this.drillDao = drillDao;
        this.wingDao = wingDao;
        this.resDao = resDao;
        this.unitService = unitService;
        this.passwordEncoder = passwordEncoder;
    }

    ////////// USER CRUD //////////

    @GetMapping("/u/create")
    public String showCreateUserForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("units", unitService.getUnits());
        return "users/create";
    }

    @PostMapping("/u/create")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/u")
    public String displayUsers(Model model){
        model.addAttribute("users", userDao.findAll());
        return "users/read";
    }

    @GetMapping("u/update/{id}")
    public String updateUser(@PathVariable long id, Model model){
        User existingUser = userDao.findById(id);
        model.addAttribute("existingUser", existingUser);
        model.addAttribute("user", new User());
        return "users/update";
    }

    @PostMapping("u/update/{id}")
    public String saveUSerUpdates(@ModelAttribute User user){
        return null;
    }

    ////////// HOTEL CRUD //////////

    @GetMapping("/h/create")
    public String showCreateHotelForm(Model model){
        model.addAttribute("hotel", new Hotel());
        return "hotels/create";
    }

    @PostMapping("/h/create")
    public String saveHotel(@ModelAttribute Hotel hotel){
        hotelDao.save(hotel);
        return "redirect:/h";
    }

    @GetMapping("/h")
    public String displayHotels(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<Hotel> hotels = hotelDao.findAllByState(loggedInUser.getUnit().getWing().getState());
        List<Hotel> hotels = hotelDao.findAll();
        model.addAttribute("hotels", hotels);
        return "hotels/read";
    }


    ////////// DRILL CRUD //////////

    @GetMapping("/d/create")
    public String ShowCreateDrillForm(Model model){
        model.addAttribute("drill", new Drill());
        model.addAttribute("wings", wingDao.findAll());
        return "/drills/create";
    }

    @PostMapping("/d/create")
    public String saveDrill(@ModelAttribute Drill drill){
        try {
            Drill newDrill = drillDao.findByName(drill.getName());
            if(newDrill.getName().equals(drill.getName())) {
                return "redirect:/d/create";
            }
        } catch (NullPointerException e) {
            drillDao.save(drill);
        }
        return "redirect:/profile";
    }

    @GetMapping("/d")
    public String displayDrills(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Drill> drills = drillDao.findAllByWingId((int) loggedInUser.getUnit().getWing().getId());
        model.addAttribute("drills", drills);
        return "drills/read";
    }

    ////////// RESERVATION CRUD //////////

    @GetMapping("/r/create")
    public String showCreateReservationForm(Model model){
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("members", userDao.findAll());
        model.addAttribute("hotels", hotelDao.findAll());
        model.addAttribute("drills", drillDao.findAll());
        return "reservations/create";
    }

    @PostMapping("/r/create")
    public String saveReservation(@ModelAttribute Reservation reservation, @ModelAttribute User user, Model model){

        List<Reservation> newReservation = resDao.findAll();

        for(Reservation r : newReservation)
        {
            if(r.getDrill().getId() == reservation.getDrill().getId() && r.getUser().getId() == reservation.getUser().getId())
            {
                String message = "This Member already has a drill with that " + reservation.getDrill().getName() + "!";
                model.addAttribute("message", message);
                return "redirect:/r/create";
            }
        }
        resDao.save(reservation);
        return "redirect:/r";
    }

    @GetMapping("/r")
    public String displayReservations(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean isAdmin = loggedInUser.isIsAdmin();
        // Dynamic reservations list based on isAdmin
        List<Reservation> reservations = (isAdmin) ? resDao.findAll() : resDao.findAllByDrillWingId(loggedInUser.getUnit().getWing().getId());
        model.addAttribute("reservations", reservations);
        return "reservations/read";
    }
}

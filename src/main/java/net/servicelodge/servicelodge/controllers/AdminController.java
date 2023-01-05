package net.servicelodge.servicelodge.controllers;

import net.servicelodge.servicelodge.models.*;
import net.servicelodge.servicelodge.repositories.*;
import net.servicelodge.servicelodge.services.UnitService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Objects;

@Controller
public class AdminController {
    private final UserRepository userDao;
    private final HotelRepository hotelDao;
    private final DrillRepository drillDao;
    private final WingRepository wingDao;
    private final ReservationRepository resDao;
    private final UnitService unitService;
    private final PasswordEncoder passwordEncoder;

    public AdminController(UserRepository userDao, HotelRepository hotelDao, DrillRepository drillDao, WingRepository wingDao, ReservationRepository resDao, UnitService unitService, PasswordEncoder passwordEncoder) {
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
    public String showCreateUserForm(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("user", new User());
            model.addAttribute("units", unitService.getUnits());
            return "users/create";
        } else {
            return "redirect:/profile";
        }
    }

    @PostMapping("/u/create")
    public String saveUser(@ModelAttribute User user, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        boolean validPassword = isValidPassword(user.getPassword());


        if(!validPassword)
        {
            String message = "The password must be 8 to 15 characters, at least one uppercase, at least one lower case, numbers, and special characters";
            model.addAttribute("message", message);
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("user", new User());
            model.addAttribute("units", unitService.getUnits());
            return "users/create";
        }

        if (loggedInUser.isIsAdmin()) {
            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
            userDao.save(user);
            return "redirect:/u";
        } else {
            return "redirect:/profile";
        }
    }

    @GetMapping("/u")
    public String displayUsers(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("users", userDao.findAll());
            return "users/read";
        } else {
            return "redirect:/profile";
        }
    }

    @GetMapping("u/{id}/update")
    public String updateUser(@PathVariable long id, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin() || id == loggedInUser.getId()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("user", userDao.getReferenceById(id));
            model.addAttribute("units", unitService.getUnits());
            return "users/update";
        } else {
            return "redirect:/profile";
        }
    }

    @PostMapping("u/{id}/update")
    public String saveUserUpdates(@ModelAttribute User user, Model model, @PathVariable long id) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        boolean validPassword = isValidPassword(user.getPassword()) || user.getPassword().equals("");


        if(!validPassword)
        {
            String message = "The password must be 8 to 15 characters, at least one uppercase, at least one lower case, numbers, and special characters";
            model.addAttribute("message", message);
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("user", userDao.getReferenceById(id));
            model.addAttribute("units", unitService.getUnits());
            return "users/update";
        }

        if (loggedInUser.isIsAdmin() || id == loggedInUser.getId()) {
            String hash = (user.getPassword().equals("")) ? userDao.getReferenceById(id).getPassword() : passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
            userDao.save(user);
            return "redirect:/u";
        } else {
            return "redirect:/profile";
        }
    }

    @PostMapping("/u/{id}/delete")
    public String deleteUser(@PathVariable long id) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            userDao.delete(userDao.getReferenceById(id));
            return "redirect:/u";
        }else {
            return "redirect:/profile";
        }
    }

    ////////// HOTEL CRUD //////////

    @GetMapping("/h/create")
    public String showCreateHotelForm(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("hotel", new Hotel());
            return "hotels/create";
        } else {
            return "redirect:/profile";
        }
    }

    @PostMapping("/h/create")
    public String saveHotel(@ModelAttribute Hotel hotel) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            hotelDao.save(hotel);
            return "redirect:/h";
        } else {
            return "redirect:/profile";
        }
    }

    @GetMapping("/h")
    public String displayHotels(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            List<Hotel> hotels = hotelDao.findAll();
            model.addAttribute("hotels", hotels);
            return "hotels/read";
        } else {
            return "redirect:/profile";
        }
    }

    @GetMapping("h/{id}/update")
    public String updateHotel(@PathVariable long id, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("hotel", hotelDao.findById(id));
            return "hotels/update";
        } else {
            return "redirect:/profile";
        }
    }

    @PostMapping("h/{id}/update")
    public String saveHotelUpdates(@ModelAttribute Hotel hotel) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            hotelDao.save(hotel);
            return "redirect:/h";
        } else {
            return "redirect:/profile";
        }
    }

    @PostMapping("/h/{id}/delete")
    public String deleteHotel(@PathVariable long id) {
        hotelDao.delete(hotelDao.findById(id));
        return "redirect:/h";
    }

    ////////// DRILL CRUD //////////

    @GetMapping("/d/create")
    public String ShowCreateDrillForm(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("drill", new Drill());
            model.addAttribute("wings", wingDao.findAll());
            return "/drills/create";
        } else {
            return "redirect:/profile";
        }
    }

    @PostMapping("/d/create")
    public String saveDrill(@ModelAttribute Drill drill, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            try {
                Drill newDrill = drillDao.findByName(drill.getName());
                if (newDrill.getName().equals(drill.getName())) {

                    String message = drill.getName() + " drill is already used!";
                    model.addAttribute("message", message);

                    model.addAttribute("drill", new Drill());
                    model.addAttribute("wings", wingDao.findAll());
                    return "/drills/create";
                }
            } catch (NullPointerException e) {
                drillDao.save(drill);
            }
        }
        return "redirect:/profile";
    }

    @GetMapping("/d")
    public String displayDrills(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            List<Drill> drills = drillDao.findAllByWingId((int) loggedInUser.getUnit().getWing().getId());
            model.addAttribute("drills", drills);
            return "drills/read";
        } else {
            return "redirect:/profile";
        }
    }

    @GetMapping("d/{id}/update")
    public String updateDrill(@PathVariable long id, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("drill", drillDao.findById(id));
            model.addAttribute("wings", wingDao.findAll());
            return "drills/update";
        } else {
            return "redirect:/profile";
        }
    }

    @PostMapping("d/{id}/update")
    public String saveDrillUpdates(@ModelAttribute Drill drill) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            drillDao.save(drill);
            return "redirect:/d";
        } else {
            return "redirect:/profile";
        }
    }


    @PostMapping("/d/{id}/delete")
    public String deleteDrill(@PathVariable long id) {
        drillDao.delete(drillDao.findById(id));
        return "redirect:/d";
    }

    ////////// RESERVATION CRUD //////////

    @GetMapping("/r/create")
    public String showCreateReservationForm(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("newReservation", new Reservation());
            model.addAttribute("members", userDao.findAll());
            model.addAttribute("hotels", hotelDao.findAll());
            model.addAttribute("drills", drillDao.findAll());
            return "reservations/create";
        } else {
            return "redirect:/profile";
        }
    }

    @PostMapping("/r/create")
    public String saveReservation(@ModelAttribute Reservation newReservation, @ModelAttribute User user, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            List<Reservation> reservations = resDao.findAllByHotelIsNotNull();
            for (Reservation r : reservations) {
                if (r.getDrill().getId() == newReservation.getDrill().getId() && r.getUser().getId() == newReservation.getUser().getId()) {
                    String message = user.getFirstName() + " " + user.getLastName() + " already has a reservation for " + newReservation.getDrill().getName() + "!";
                    model.addAttribute("message", message);
                    model.addAttribute("newReservation", new Reservation());
                    model.addAttribute("members", userDao.findAll());
                    model.addAttribute("hotels", hotelDao.findAll());
                    model.addAttribute("drills", drillDao.findAll());
                    return "reservations/create";
                }
            }
            resDao.save(newReservation);
            return "redirect:/r";
        } else {
            return "redirect:/profile";
        }
    }

    @GetMapping("/r")
    public String displayReservations(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Reservation> reservations = (loggedInUser.isIsAdmin()) ? resDao.findAllByHotelIsNotNull() : resDao.findAllByUserAndHotelIsNotNull(loggedInUser);
        List<Reservation> requests = (loggedInUser.isIsAdmin()) ? resDao.findAllByHotelIsNull() : resDao.findAllByUserAndHotelIsNull(loggedInUser);
        model.addAttribute("notifications", requests.size());
        model.addAttribute("members", userDao.findAll());
        model.addAttribute("hotels", hotelDao.findAll());
        model.addAttribute("drills", drillDao.findAll());
        model.addAttribute("user", loggedInUser);
        model.addAttribute("reservations", reservations);
        model.addAttribute("requests", requests);
        return "reservations/read";
    }

    @GetMapping("/r/{id}")
    public String displayReservationDetails(@PathVariable long id, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reservation res = resDao.findById(id);
        if (loggedInUser.isIsAdmin() || res.getUser().getId() == loggedInUser.getId()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("user", loggedInUser);
            model.addAttribute("reservation", res);
            return "reservations/detail";
        }else {
            return "redirect:/profile";
        }
    }


        @GetMapping("/r/{id}/update")
    public String updateReservation(@PathVariable long id, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("members", userDao.findAll());
            model.addAttribute("hotels", hotelDao.findAll());
            model.addAttribute("drills", drillDao.findAll());
            model.addAttribute("user", loggedInUser);
            model.addAttribute("reservation", resDao.findById(id));
            return "reservations/update";
        } else {
            return "redirect:/profile";
        }
    }

    @PostMapping("/r/{id}/update")
    public String saveReservationUpdates(@PathVariable long id, @ModelAttribute Reservation reservation, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            if (reservation.getHotel() == null || Objects.equals(reservation.getResNum(), "")) {
                String message = (reservation.getHotel() == null) ? "Please select a hotel." : "Please provide reservation number.";
                model.addAttribute("message", message);
                model.addAttribute("members", userDao.findAll());
                model.addAttribute("hotels", hotelDao.findAll());
                model.addAttribute("drills", drillDao.findAll());
                model.addAttribute("user", loggedInUser);
                model.addAttribute("reservation", resDao.findById(id));
                return "/reservations/update";
            }
            resDao.save(reservation);
            return "redirect:/r";
        } else {
            return "redirect:/profile";
        }
    }

    @PostMapping("/r/{id}/delete")
    public String deleteReservation(@PathVariable long id) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reservation res = resDao.findById(id);
        if (loggedInUser.isIsAdmin() || res.getUser().getId() == loggedInUser.getId()) {
            resDao.delete(res);
            return "redirect:/r";
        } else {
            return "redirect:/profile";
        }
    }

    @GetMapping("/r/request")
    public String showRequestReservationForm(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!loggedInUser.isIsAdmin()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            model.addAttribute("newReservation", new Reservation());
            model.addAttribute("member", userDao.findById(loggedInUser.getId()));
            model.addAttribute("drills", drillDao.findAll());
            return "reservations/request";
        } else {
            return "redirect:/profile";
        }
    }

    @PostMapping("/r/request")
    public String requestReservation(@ModelAttribute Reservation newReservation, @ModelAttribute User user, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!loggedInUser.isIsAdmin()) {
            List<Reservation> reservations = resDao.findAll();
            for (Reservation r : reservations) {
                if (r.getDrill().getId() == newReservation.getDrill().getId() && r.getUser().getId() == newReservation.getUser().getId()) {
                    String message = (r.getHotel() == null) ? "You already have a request pending for " + newReservation.getDrill().getName() + "!"
                            : "You already have a reservation for " + newReservation.getDrill().getName() + "!";
                    model.addAttribute("message", message);
                    model.addAttribute("newReservation", new Reservation());
                    model.addAttribute("member", userDao.findById(loggedInUser.getId()));
                    model.addAttribute("drills", drillDao.findAll());
                    return "reservations/request";
                }
            }
            resDao.save(newReservation);
            return "redirect:/r";
        } else {
            return "redirect:/profile";
        }
    }



    ////////// DASHBOARD //////////
    @GetMapping("/dashboard")
    public String dashboards(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.isIsAdmin()) {
            model.addAttribute("notifications", resDao.findAllByHotelIsNull().size());
            List<Reservation> reservations =  resDao.findAllByHotelIsNotNull();
            int[] monthlyData = new int[12];
            for (Reservation res : reservations){
                String month = res.getDrill().getName();
                switch (month){
                    case "January 2023": { monthlyData[0]++; break; }
                    case "February 2023": { monthlyData[1]++; break; }
                    case "March 2023": { monthlyData[2]++; break; }
                    case "April 2023": { monthlyData[3]++; break; }
                    case "May 2023": { monthlyData[4]++; break; }
                    case "June 2023": { monthlyData[5]++; break; }
                    case "July 2023": { monthlyData[6]++; break; }
                    case "August 2023": { monthlyData[7]++; break; }
                    case "September 2023": { monthlyData[8]++; break; }
                    case "October 2023": { monthlyData[9]++; break; }
                    case "November 2023": { monthlyData[10]++; break; }
                    case "December 2023": { monthlyData[11]++; break; }
                }
            }
            model.addAttribute("monthlyData", monthlyData);
            return "dashboard";
        } else {
            return "redirect:/profile";
        }
    }

    //validate password
    public boolean isValidPassword(String password)
    {
        boolean isValid = true;
        if (password.length() > 15 || password.length() < 8)
        {
            System.out.println("Password must be less than 20 and more than 8 characters in length.");
            isValid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars ))
        {
            System.out.println("Password must have at least one uppercase character");
            isValid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars ))
        {
            System.out.println("Password must have at least one lowercase character");
            isValid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers ))
        {
            System.out.println("Password must have at least one number");
            isValid = false;
        }
        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(specialChars ))
        {
            System.out.println("Password must have at least one special character among @#$%");
            isValid = false;
        }
        return isValid;
    }
}



package net.servicelodge.servicelodge.controllers;

import net.servicelodge.servicelodge.models.Unit;
import net.servicelodge.servicelodge.models.User;
import net.servicelodge.servicelodge.repositories.UnitRepository;
import net.servicelodge.servicelodge.repositories.UserRepository;
import net.servicelodge.servicelodge.services.UnitService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository userDao;
    private UnitService unitService;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, UnitService unitService, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.unitService = unitService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/create/user")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("units", unitService.getUnits());
        System.out.println(unitService.getUnits());
        return "user";
    }

    @PostMapping("/create/user")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }
}

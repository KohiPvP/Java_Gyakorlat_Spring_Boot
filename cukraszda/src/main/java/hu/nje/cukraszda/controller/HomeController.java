package hu.nje.cukraszda.controller;

import hu.nje.cukraszda.auth.User;
import hu.nje.cukraszda.auth.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping
    public String index() {
        return "index"; // templates/index.html
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @Autowired
    private UserRepo userRepo;
    @PostMapping("/registering")
    public String registering(@ModelAttribute User user, Model model) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("msg", "Email Already Exists");
            return "register";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepo.save(user);
        return "redirect:/login";
    }

    // Üzenetek menü -- Regisztrált felhasználóknak
    @GetMapping("/uzenetek")
    public String Uzenetek() {
        return "uzenetek";
    }

    // Admin menü -- Regisztrált felhasználóknak admin joggal
    // Admin menün belül lesz a CRUD menü
    @GetMapping("/admin/crud")
    public String admin() {
        return "admin";
    }
}

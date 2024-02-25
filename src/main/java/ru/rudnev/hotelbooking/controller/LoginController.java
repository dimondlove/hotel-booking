package ru.rudnev.hotelbooking.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.rudnev.hotelbooking.config.MyUserDetails;


@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/")
    public String home(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails);
        return "index";
    }
}

package ru.rudnev.hotelbooking.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rudnev.hotelbooking.dto.UserRegistrationDto;
import ru.rudnev.hotelbooking.service.UserService;

@Controller
@AllArgsConstructor
@RequestMapping("/registration")
public class UserRegistrationController {
    private final UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "user/registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto, BindingResult result, Model model) {
        if (userService.IsUserUnique(userRegistrationDto)) {
            model.addAttribute("message", "Пользователь с таким адресом электронной почты уже существует!");
            return "user/registration";
        }
        userService.saveUser(userRegistrationDto);
        return "redirect:/registration?success";
    }

    @GetMapping("/admin")
    public String showRegistrationAdminForm() {
        return "admin/registration";
    }

    @PostMapping("/admin")
    public String registerAdminAccount(@ModelAttribute("user")UserRegistrationDto userRegistrationDto) {
        userService.saveAdmin(userRegistrationDto);
        return "redirect:/registration?success";
    }
}

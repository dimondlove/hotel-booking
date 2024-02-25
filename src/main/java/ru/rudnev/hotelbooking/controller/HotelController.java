package ru.rudnev.hotelbooking.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rudnev.hotelbooking.config.MyUserDetails;
import ru.rudnev.hotelbooking.dto.HotelDto;
import ru.rudnev.hotelbooking.service.HotelService;

@Controller
@AllArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("/hotels")
    public String userGetAllHotels(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails);
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "user/hotels";
    }

    @GetMapping("/admin/hotels")
    public String getAllHotels(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails);
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "admin/hotels";
    }

    @GetMapping("/admin/hotels/new")
    public String showHotelNewForm(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails);
        model.addAttribute("hotel", hotelService.addHotel());

        return "admin/hotel_form";
    }

    @PostMapping("/admin/hotels/save")
    public String saveHotel(HotelDto hotelDto) {
        hotelService.saveHotel(hotelDto);

        return "redirect:/admin/hotels";
    }

    @GetMapping("/admin/hotels/delete/{id}")
    public String deleteHotel(@PathVariable Long id, Model model) {
        hotelService.deleteHotel(id);

        return "redirect:/admin/hotels";
    }
}

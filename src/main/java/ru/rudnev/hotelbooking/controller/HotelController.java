package ru.rudnev.hotelbooking.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rudnev.hotelbooking.dto.HotelDto;
import ru.rudnev.hotelbooking.service.HotelService;

@Controller
@AllArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("/hotels")
    public String getAllUsers(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "hotel/hotels";
    }

    @GetMapping("/hotels/new")
    public String showHotelNewForm(Model model) {
        model.addAttribute("hotel", hotelService.addHotel());

        return "hotel/hotel_form";
    }

    @PostMapping("/hotels/save")
    public String saveHotel(HotelDto hotelDto) {
        hotelService.saveHotel(hotelDto);

        return "redirect:/hotels";
    }

    @GetMapping("/hotels/edit/{id}")
    public String editHotel(@PathVariable("id") Long id, Model model) {
        model.addAttribute("hotel", hotelService.editHotel(id));

        return "hotel/hotel_form";
    }

    @GetMapping("/hotels/delete/{id}")
    public String deleteHotel(@PathVariable Long id, Model model) {
        hotelService.deleteHotel(id);

        return "redirect:/hotels";
    }
}

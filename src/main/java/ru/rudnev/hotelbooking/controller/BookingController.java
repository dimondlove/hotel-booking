package ru.rudnev.hotelbooking.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rudnev.hotelbooking.config.MyUserDetails;
import ru.rudnev.hotelbooking.dto.BookingDto;
import ru.rudnev.hotelbooking.service.BookingService;

@Controller
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/admin/bookings")
    public String getAllBookings(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails);
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "admin/booking";
    }

    @GetMapping("/rooms/{roomId}/bookings/new")
    public String showBookingNewForm(@PathVariable("roomId") Long roomId, @AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails);
        model.addAttribute("booking", bookingService.addBookingRoom(roomId));
        return "user/booking_form";
    }

    @PostMapping("/bookings/save")
    public String saveBooking(BookingDto bookingDto) {
        bookingService.saveBooking(bookingDto);
        return "redirect:/";
    }

    @GetMapping("/admin/bookings/{id}/delete")
    public String deleteBooking(@PathVariable Long id, Model model) {
        bookingService.deleteBooking(id);

        return "redirect:/admin/bookings";
    }
}

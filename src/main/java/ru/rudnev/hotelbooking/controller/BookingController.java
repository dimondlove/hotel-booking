package ru.rudnev.hotelbooking.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rudnev.hotelbooking.dto.BookingDto;
import ru.rudnev.hotelbooking.service.BookingService;

@Controller
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "booking/booking";
    }

    @GetMapping("/rooms/{roomId}/bookings/new")
    public String showBookingNewForm(@PathVariable("roomId") Long roomId, Model model) {
        model.addAttribute("booking", bookingService.addBookingRoom(roomId));
        return "booking/booking_form";
    }

    @PostMapping("/bookings/save")
    public String saveBooking(BookingDto bookingDto) {
        bookingService.saveBooking(bookingDto);
        return "redirect:/bookings";
    }

    @GetMapping("/bookings/{id}/delete")
    public String deleteBooking(@PathVariable Long id, Model model) {
        bookingService.deleteBooking(id);

        return "redirect:/bookings";
    }
}

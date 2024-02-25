package ru.rudnev.hotelbooking.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rudnev.hotelbooking.config.MyUserDetails;
import ru.rudnev.hotelbooking.dto.RoomDto;
import ru.rudnev.hotelbooking.service.RoomService;


@Controller
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/admin/rooms")
    public String getAllRooms(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails);
        model.addAttribute("rooms", roomService.getAllRooms());
        return "admin/rooms";
    }

    @GetMapping("/hotels/{hotelId}/rooms")
    public String userGelAllHotelRooms(@PathVariable("hotelId") Long hotelId, @AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails);
        model.addAttribute("rooms", roomService.getAllHotelRooms(hotelId));

        return "user/rooms";
    }

    @GetMapping("/admin/hotels/{hotelId}/rooms")
    public String gelAllHotelRooms(@PathVariable("hotelId") Long hotelId, @AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails);
        model.addAttribute("rooms", roomService.getAllHotelRooms(hotelId));

        return "admin/rooms";
    }

    @GetMapping("/admin/rooms/new")
    public String showRoomNewForm(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails);
        model.addAttribute("room", roomService.addRoom());

        return "admin/room_form";
    }

    @GetMapping("/admin/hotels/{hotelId}/rooms/new")
    public String showRoomNewForm(@PathVariable("hotelId") Long hotelId, @AuthenticationPrincipal MyUserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails);
        model.addAttribute("room", roomService.addHotelRoom(hotelId));

        return "admin/room_form";
    }

    @PostMapping("/admin/rooms/save")
    public String saveRoom(RoomDto roomDto) {
        roomService.saveRoom(roomDto);

        return "redirect:/admin/rooms";
    }

    @PostMapping("/admin/hotels/{hotelId}/rooms/save")
    public String saveRoom(@PathVariable("hotelId") Long hotelId, RoomDto roomDto) {
        roomService.saveRoom(roomDto);

        return "redirect:/admin/hotels/{hotelId}/rooms";
    }

    @GetMapping("/admin/hotels/{hotelId}/rooms/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);

        return "redirect:/admin/hotels/{hotelId}/rooms";
    }
}

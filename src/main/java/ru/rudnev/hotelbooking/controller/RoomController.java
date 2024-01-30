package ru.rudnev.hotelbooking.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rudnev.hotelbooking.dto.HotelDto;
import ru.rudnev.hotelbooking.dto.RoomDto;
import ru.rudnev.hotelbooking.service.HotelService;
import ru.rudnev.hotelbooking.service.RoomService;

import java.util.Collection;

@Controller
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/rooms")
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "room/rooms";
    }

    @GetMapping("/hotels/{hotelId}/rooms")
    public String gelAllHotelRooms(@PathVariable("hotelId") Long hotelId, Model model) {
        model.addAttribute("rooms", roomService.getAllHotelRooms(hotelId));

        return "room/rooms";
    }

    @GetMapping("/rooms/new")
    public String showRoomNewForm(Model model) {
        model.addAttribute("room", roomService.addRoom());

        return "room/room_form";
    }

    @GetMapping("/hotels/{hotelId}/rooms/new")
    public String showRoomNewForm(@PathVariable("hotelId") Long hotelId, Model model) {
        model.addAttribute("room", roomService.addHotelRoom(hotelId));

        return "room/room_form";
    }

    @PostMapping("/rooms/save")
    public String saveRoom(RoomDto roomDto) {
        roomService.saveRoom(roomDto);

        return "redirect:/rooms";
    }

    @PostMapping("/hotels/{hotelId}/rooms/save")
    public String saveRoom(@PathVariable("hotelId") Long hotelId, RoomDto roomDto) {
        roomService.saveRoom(roomDto);

        return "redirect:/hotels/{hotelId}/rooms";
    }

    @GetMapping("/rooms/edit/{id}")
    public String editRoom(@PathVariable("id") Long id, Model model) {
        model.addAttribute("room", roomService.editRoom(id));

        return "room/room_form";
    }

    @GetMapping("/hotels/{hotelId}/rooms/delete/{id}")
    public String deleteRoom(@PathVariable Long id, Model model) {
        roomService.deleteRoom(id);

        return "redirect:/hotels/{hotelId}/rooms";
    }
}

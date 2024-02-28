package com.train.controller;

import com.train.dto.UserSeatDto;
import com.train.model.Ticket;
import com.train.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/train")
public class TrainController {
    @Autowired
    TrainService ticketService;

    @GetMapping("/getAll")
    public Map<String, Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/viewUserSeats/{section}")
    public Map<String, String> viewUsersAndSeats(@PathVariable String section) {
        return ticketService.viewUsersAndSeats(section);
    }
 
    @PostMapping("/modifyUserSeat/")
    public String modifyUserSeat(@RequestBody UserSeatDto userDto) {
        return ticketService.modifyUserSeat(userDto.userId, userDto.newSection, userDto.newSection);
    }
}


package com.train.controller;

import com.train.dto.TicketDto;
import com.train.model.Ticket;
import com.train.model.User;
import com.train.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/booking")
public class TicketController {

    @Autowired
    TicketService ticketService;

    public static Map<String, Ticket> ticketMap = new ConcurrentHashMap<>();
    public static Map<String, String> userTic = new ConcurrentHashMap<>();

    @PostMapping("/createTickets")
    public Ticket createTicketBooking(@RequestBody TicketDto ticketDto) {

        User user = UserController.userMap.get(ticketDto.getUserId());
        Ticket ticket1 = new Ticket();
        
        if (ticketDto.getUserId().isEmpty()) {
            throw new RuntimeException("UserId Not found");
        } else {
            ticket1.setUser(user);
            ticket1.setFrom(ticketDto.getFrom());
            ticket1.setTo(ticketDto.getTo());
            ticket1.setSection(generateRandomSections());
            ticket1.setSeat(generateRandomSeat());
            ticket1.setSeat(ticket1.getSection() + ticketDto.getSeat());
            ticket1.setPricePaid(ticketDto.getPricePaid());

            ticketMap.putIfAbsent(user.getUserId(), ticket1);
            userTic.putIfAbsent(user.getUserId(), ticket1.getSeat());
            return ticket1;
        }
    }

    @GetMapping("/viewReceipt/{userId}")
    public Ticket viewReceipt(@PathVariable String userId) {
        return ticketService.viewReceipt(userId);
    }

    private String generateRandomSections() {
        return (Math.random() < 0.5) ? "A" : "B";
    }

    private String generateRandomSeat() {
        Random random = new Random();

        int seatNumber = 1 + random.nextInt(10);

        return String.valueOf(seatNumber);
    }

}

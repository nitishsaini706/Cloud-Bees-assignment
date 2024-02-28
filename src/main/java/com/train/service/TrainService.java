package com.train.service;


import com.train.model.Ticket;
import com.train.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.train.controller.TicketController.ticketMap;
import static com.train.controller.TicketController.userTic;

@Service
public class TrainService {
    static Map<String, String> userSeats = new HashMap<>();

    public Map<String, Ticket> getAllTickets() {
        return ticketMap;
    }

    public Map<String, String> viewUsersAndSeats(String section) {

        Map<String, String> sectionSeats = new HashMap<>();
        if (section != null) {
            for (Map.Entry<String, String> entry : userTic.entrySet()) {
                if (entry.getValue().startsWith(section)) {
                    sectionSeats.put(entry.getKey(), entry.getValue());
                }
            }
        } else {
            System.out.println("section is null");
        }

        return sectionSeats;
    }

    public String modifyUserSeat(String userId, String newSection, String newSeat) {

        if (!userId.isEmpty()) {
            Ticket ticket = new Ticket();
            User user = new User();

            ticket.setSection(newSection);
            ticket.setSeat(newSeat);
            userSeats.put(userId, newSeat);
            ticketMap.get(userId).setSection(newSection);
            ticketMap.get(userId).setSeat(newSeat);
        } else {
            throw new RuntimeException("UserId Not Found");
        }

        return "User's seat modified. New seat: " + newSeat;
    }

}

package com.train.service;

import com.train.controller.TicketController;
import com.train.model.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    public Ticket viewReceipt(String userId) {
        if (userId.isEmpty()) {
            throw new RuntimeException("UserId Not Found");
        } else {
            return TicketController.ticketMap.get(userId);
        }
    }

}

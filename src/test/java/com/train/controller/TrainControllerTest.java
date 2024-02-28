package com.train.controller;

import com.train.dto.TicketDto;
import com.train.dto.UserSeatDto;
import com.train.model.Ticket;
import com.train.model.User;
import com.train.service.TrainService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TrainControllerTest {

    @Mock
    private TrainService trainService;

    @InjectMocks
    private TrainController trainController;

//    @Test
//    public void testGetAllTickets() {
//        Map<String, Ticket> mockTicketMap = new HashMap<>();
//
//        Ticket ticket1 = new Ticket();
//        TicketDto ticketDto = new TicketDto();
//        User user = new User();
//
//        ticket1.setUser(user);
//        ticket1.setFrom(ticketDto.getFrom());
//        ticket1.setTo(ticketDto.getTo());
//        ticket1.setSection(generateRandomSections());
//        ticket1.setSeat(ticket1.getSection() + ticketDto.getSeat());
//        ticket1.setPricePaid(ticketDto.getPricePaid());
//
//        mockTicketMap.put(user.getUserId(), ticket1);
//
//        when(trainService.getAllTickets()).thenReturn(mockTicketMap);
//
//        Map<String, Ticket> result = trainController.getAllTickets();
//
//        assertEquals(mockTicketMap, result);
//    }

    private String generateRandomSections() {
        return (Math.random() < 0.5) ? "A" : "B";
    }

//    @Test
//    public void testViewUsersAndSeats() {
//        String section = "A";
//        Map<String, String> mockUserSeatsMap = new HashMap<>();
//
//        Ticket ticket1 = new Ticket();
//        TicketDto ticketDto = new TicketDto();
//        User user = new User();
//
//        ticket1.setSection(generateRandomSections());
//        ticket1.setSeat(ticket1.getSection() + ticketDto.getSeat());
//
//        mockUserSeatsMap.put(user.getUserId(), ticket1.getSeat());
//
//        when(trainService.viewUsersAndSeats(section)).thenReturn(mockUserSeatsMap);
//
//        Map<String, String> result = trainController.viewUsersAndSeats(section);
//
//        assertEquals(mockUserSeatsMap, result);
//    }

//    @Test
//    public void testModifyUserSeat() {
//        UserSeatDto userSeatDto = new UserSeatDto();
//        String userId = "user123";
//        String newSection = "B";
//        String newSeat = "15";
//
//        userSeatDto.userId = userId;
//        userSeatDto.newSection = newSection;
//        userSeatDto.newSeat = newSeat;
//
//        String expectedResult = "User's seat modified. New seat: " + "15";
//
//        when(trainService.modifyUserSeat(userId, newSection, newSeat)).thenReturn(expectedResult);
//
//        String result = trainController.modifyUserSeat(userSeatDto);
//
//        assertEquals(expectedResult, result);
//    }
}

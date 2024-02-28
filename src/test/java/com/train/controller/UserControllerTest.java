package com.train.controller;

import com.train.dto.UserDto;
import com.train.model.Ticket;
import com.train.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserControllerTest {

    @Mock
    private Map<String, User> userMapMock;

    @Mock
    private Map<String, Ticket> ticketMapMock;

    @InjectMocks
    private UserController userController;


    @Mock
    private TicketController ticketController;


    @BeforeEach
    void setUp() {
        UserController.userMap = userMapMock;
        TicketController.ticketMap = ticketMapMock;
    }

    @Test
    public void testCreateUser() {


        UserDto userDto = new UserDto();
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setEmail("john.doe@example.com");

        String userId = "qwqs-dufr-nfrd";

        User createdUser = userController.createUser(userDto);

        // Verify that the userMap's putIfAbsent method was called with the correct arguments
        verify(userMapMock, times(1)).putIfAbsent("qwqs-dufr-nfrd", createdUser);

        // Verify that the created user has the correct properties
        assertEquals(userDto.getFirstName(), createdUser.getFirstName());
        assertEquals(userDto.getLastName(), createdUser.getLastName());
        assertEquals(userDto.getEmail(), createdUser.getEmail());
    }

    @Test
    public void testGetAllUser() {
        Map<String, User> mockUserMap = new HashMap<>();
        UserDto userDto = new UserDto();
        userDto.setFirstName("Abc");
        userDto.setLastName("Def");
        userDto.setEmail("Abc.def@example.com");
        String userId = "jfr-gdrh-sgrh";
        User createdUsers = userController.createUser(userDto);

        verify(userMapMock, times(1)).putIfAbsent("jfr-gdrh-sgrh", createdUsers);

        UserDto userDto1 = new UserDto();
        userDto.setFirstName("Xyz");
        userDto.setLastName("JKL");
        userDto.setEmail("XYZ.JKL@example.com");
        String userId1 = "hrd-rfdr-ufht";
        User createdUsers1 = userController.createUser(userDto);

        verify(userMapMock, times(1)).putIfAbsent("hrd-rfdr-ufht", createdUsers1);


        when(userMapMock.entrySet()).thenReturn(mockUserMap.entrySet());

        Map<String, User> result = userController.getAllUser();

        assertEquals(mockUserMap, result);
    }

    @Test
    public void testRemoveUser() {

        String userId = "fds-sjcd-hhc";

        when(userMapMock.remove(userId)).thenReturn(new User());

        when(ticketMapMock.remove(userId)).thenAnswer(invocation -> "User removed from seat " + "fds-sjcd-hhc");

        String result = userController.removeUser(userId);

        verify(userMapMock, times(1)).remove(eq(userId));
        verify(ticketMapMock, times(1)).remove(eq(userId));

        String expectedResult = "User removed from seat " + userId;
        assertEquals(expectedResult, result, "Result message does not match");
    }
}

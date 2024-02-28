package com.train.controller;

import com.train.dto.UserDto;
import com.train.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static com.train.controller.TicketController.ticketMap;

@RestController
@RequestMapping("/users")

public class UserController {

    public static Map<String, User> userMap = new ConcurrentHashMap<>();

    @PostMapping("/createUsers")
    public User createUser(@RequestBody UserDto userDto) {

        User user = new User();

        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        userMap.putIfAbsent(userId, user);
        return user;
    }

    @GetMapping("/getAllUsers")
    public Map<String, User> getAllUser() {
        return userMap;
    }

    @DeleteMapping("/removeUser/{userId}")
    public String removeUser(@PathVariable String userId) {

        userMap.remove(userId);
        ticketMap.remove(userId);

        return "User removed from seat " + userId;

    }

}

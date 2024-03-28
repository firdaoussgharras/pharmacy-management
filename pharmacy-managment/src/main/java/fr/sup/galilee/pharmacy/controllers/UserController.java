package fr.sup.galilee.pharmacy.controllers;

import fr.sup.galilee.pharmacy.dtos.UserDto;
import fr.sup.galilee.pharmacy.entities.User;
import fr.sup.galilee.pharmacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto) {
        User user = User.builder()
                .firstname(userDto.getFirstName())
                .lastname(userDto.getLastName())
                .email(userDto.getEmail())
                .active(true).build();
        User savedUser = userService.addUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}

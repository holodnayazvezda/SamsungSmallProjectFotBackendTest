package com.example.samsungsmallprojectfotbackendtest.user;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.createUser(createUserDto));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.updateUser(createUserDto));
    }

    @GetMapping
    public ResponseEntity<User> getUser(@RequestParam Integer id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Integer id) {
        userService.deleteUser(id);
    }
}

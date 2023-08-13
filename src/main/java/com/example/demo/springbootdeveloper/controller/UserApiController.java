package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.AddUserRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateUserRequest;
import com.example.demo.springbootdeveloper.DTO.UserResponse;
import com.example.demo.springbootdeveloper.domain.User;
import com.example.demo.springbootdeveloper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request) {
        User savedUser = userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<UserResponse> findUser(@PathVariable long id) {
        User user = userService.findById(id);

        return ResponseEntity.ok()
                .body(new UserResponse(user));
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UpdateUserRequest request) {
        User updatedUser = userService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedUser);
    }
}

package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.AddUserRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateUserPwRequest;
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

    @GetMapping("/api/login/{email}/{pw}")
    public Boolean loginUser(@PathVariable String email, @PathVariable String pw) {
        User user = userService.findByEmail(email);

        if(user == null) {
            throw new IllegalArgumentException("user not found");
        } else if (!pw.equals(user.getPw())) {
            return false;
        } else {
            return true;
        }
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<UserResponse> findUser(@PathVariable long id) {
        User user = userService.findById(id);

        return ResponseEntity.ok()
                .body(new UserResponse(user));
    }

    @GetMapping("/api/user/phone/{phone}")
    public ResponseEntity<String> findByPhone(@PathVariable String phone) {
        User user = userService.findByPhone(phone);

        return ResponseEntity.ok()
                .body(user.getEmail());
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

    @PutMapping("/api/user/email/{email}")
    public ResponseEntity<User> updateUserPw(@PathVariable String email, @RequestBody UpdateUserPwRequest request) {
        User user = userService.findByEmail(email);

        if(user == null) {
            throw new IllegalArgumentException("user not found");
        } else {
            User updatedUser = userService.updatePw(user.getEmail(), request);

            return ResponseEntity.ok()
                    .body(updatedUser);
        }
    }

    @PutMapping("/api/user/updatepw/{email}/{pw}")
    public ResponseEntity<User> updateUserPwByEmailAndPw(@PathVariable String email, @PathVariable String pw, @RequestBody UpdateUserPwRequest request) {
        User user = userService.findByEmail(email);

        if(pw.equals(user.getPw())) {
            User updatedUser = userService.updatePw(user.getEmail(), request);
            return ResponseEntity.ok()
                    .body(updatedUser);
        } else {
            throw new IllegalArgumentException("not match pw");
        }
    }
}

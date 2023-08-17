package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.User;
import lombok.Getter;

@Getter
public class UserPhoneResponse {

    private final String email;

    public UserPhoneResponse(User user) {
        this.email = user.getEmail();
    }
}

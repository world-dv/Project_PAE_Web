package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.User;
import lombok.Getter;

import java.sql.Date;

@Getter
public class UserResponse {

    private final String pw;
    private final String name;
    private final String address;
    private final String phone;
    private final Date date;
    private final boolean helper;
    private final boolean gender;
    private final String nickname;
    private final float location_x;
    private final float location_y;

    public UserResponse(User user) {
        this.pw = user.getPw();
        this.name = user.getName();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.date = user.getDate();
        this.helper = user.isHelper();
        this.gender = user.isGender();
        this.nickname = user.getNickname();
        this.location_x = user.getLocation_x();
        this.location_y = user.getLocation_y();
    }
}

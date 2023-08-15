package com.example.demo.springbootdeveloper.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateUserRequest {

    private String pw;
    private String name;
    private String email;
    private String address;
    private String phone;
    private Date date;
    private boolean helper;
    private boolean gender;
    private String nickname;
    private float location_x;
    private float location_y;
    private Timestamp updated_at;
}

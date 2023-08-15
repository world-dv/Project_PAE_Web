package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddUserRequest {

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
    private Timestamp created_at;
    private Timestamp updated_at;

    public User toEntity() {
        return User.builder()
                .pw(pw)
                .name(name)
                .email(email)
                .address(address)
                .phone(phone)
                .date(date)
                .helper(helper)
                .gender(gender)
                .nickname(nickname)
                .location_x(location_x)
                .location_y(location_y)
                .created_at(created_at)
                .updated_at(updated_at)
                .build();
    }
}

package com.example.demo.springbootdeveloper.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateUserPwRequest {

    private String pw;
    private Date date;
}

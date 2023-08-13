package com.example.demo.springbootdeveloper.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateConsultantRequest {

    private String name;
    private Integer cost;
    private boolean gender;
    private String email;
    private String detail;
    private String field;
    private Timestamp updated_at;
}

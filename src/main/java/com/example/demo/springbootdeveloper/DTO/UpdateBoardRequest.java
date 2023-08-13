package com.example.demo.springbootdeveloper.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateBoardRequest {

    private String title;
    private String category;
    private String content;
    private Date date;
    private String nickname;
    private Timestamp updated_at;
}

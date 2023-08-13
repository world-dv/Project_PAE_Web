package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Consult;
import lombok.Getter;

import java.sql.Date;

@Getter
public class ConsultResponse {

    private final  String title;
    private final String category;
    private final String content;
    private final String img;

    public ConsultResponse(Consult consult) {
        this.title = consult.getTitle();
        this.category = consult.getCategory();
        this.content = consult.getContent();
        this.img = consult.getImg();
    }
}

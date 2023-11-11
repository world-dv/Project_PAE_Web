package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Consult;
import lombok.Getter;

import java.sql.Date;

@Getter
public class ConsultResponseOne {

    private final Long id;
    private final String title;
    private final String category;
    private final String content;
    private final Date date;
    private final String url;
    private final String img;

    public ConsultResponseOne(Consult consult) {
        this.id = consult.getId();
        this.title = consult.getTitle();
        this.category = consult.getCategory();
        this.content = consult.getContent();
        this.date = consult.getDate();
        this.url = "https://www.youtube.com/watch?v=" + consult.getUrl();
        this.img = consult.getImg() + consult.getImg2() + consult.getImg3();
    }
}

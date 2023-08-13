package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Info;
import lombok.Getter;

import java.sql.Date;

@Getter
public class InfoResponseOne {

    private final String title;
    private final String content;
    private final String category;
    private final Date date;
    private final String url;
    private final String img;

    public InfoResponseOne(Info info) {
        this.title = info.getTitle();
        this.content = info.getContent();
        this.category = info.getCategory();
        this.date = info.getDate();
        this.url = info.getUrl();
        this.img = info.getImg();
    }
}

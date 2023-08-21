package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Info;
import lombok.Getter;

import java.sql.Date;

@Getter
public class InfoResponse {

    private final String title;
    private final String category;
    private final String content;

    public InfoResponse(Info info) {
        this.title = info.getTitle();
        this.category = info.getCategory();
        this.content = info.getContent();
    }
}



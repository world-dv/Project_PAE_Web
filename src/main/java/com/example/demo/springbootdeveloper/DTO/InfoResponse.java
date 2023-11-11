package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Info;
import lombok.Getter;

import java.sql.Date;

@Getter
public class InfoResponse {

    private final Long id;
    private final String title;
    private final String category;
    private final String content;

    public InfoResponse(Info info) {
        this.id = info.getId();
        this.title = info.getTitle();
        this.category = info.getCategory();
        this.content = info.getContent();
    }
}



package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.ExtraContent;
import lombok.Getter;

@Getter
public class ExtraContentResponse {

    private final String content;

    public ExtraContentResponse(ExtraContent add) {
        this.content = add.getContent();
    }
}

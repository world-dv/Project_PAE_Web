package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Add;
import lombok.Getter;

@Getter
public class AddResponse {

    private final String content;

    public AddResponse(Add add) {
        this.content = add.getContent();
    }
}

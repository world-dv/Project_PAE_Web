package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Board;
import lombok.Getter;

import java.sql.Date;

@Getter
public class BoardResponse {

    private final String title;
    private final String category;
    private final String nickname;

    public BoardResponse(Board board) {
        this.title = board.getTitle();
        this.category = board.getCategory();
        this.nickname = board.getNickname();
    }
}

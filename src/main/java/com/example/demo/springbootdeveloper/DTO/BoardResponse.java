package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Board;
import lombok.Getter;

import java.sql.Date;

@Getter
public class BoardResponse {

    private final String title;
    private final String category;
    private final String content;
    private final Date date;
    private final String nickname;

    public BoardResponse(Board board) {
        this.title = board.getTitle();
        this.category = board.getCategory();
        this.content = board.getContent();
        this.date = board.getDate();
        this.nickname = board.getNickname();
    }
}

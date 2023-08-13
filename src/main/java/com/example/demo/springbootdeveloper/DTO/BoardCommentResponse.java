package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Board_comment;
import lombok.Getter;

import java.sql.Date;

@Getter
public class BoardCommentResponse {

    private final long boardId;
    private final String nickname;
    private final String content;
    private final Date date;

    public BoardCommentResponse(Board_comment boardComment) {
        this.boardId = boardComment.getBoardId();
        this.nickname = boardComment.getNickname();
        this.content = boardComment.getContent();
        this.date = boardComment.getDate();
    }
}

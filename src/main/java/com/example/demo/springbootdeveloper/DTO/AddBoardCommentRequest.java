package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Board_comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddBoardCommentRequest {

    private long boardId;
    private String nickname;
    private String content;
    private Date date;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Board_comment toEntity() {

        return Board_comment.builder()
                .boardId(boardId)
                .nickname(nickname)
                .content(content)
                .date(date)
                .created_at(created_at)
                .updated_at(updated_at)
                .build();
    }
}

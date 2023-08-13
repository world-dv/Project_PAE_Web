package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Board;
import com.example.demo.springbootdeveloper.domain.User;
import com.example.demo.springbootdeveloper.service.BoardService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddBoardRequest {

    private String title;
    private String category;
    private String content;
    private Date date;
    private String nickname;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Board toEntity() {

        return Board.builder()
                .title(title)
                .category(category)
                .content(content)
                .date(date)
                .nickname(nickname)
                .created_at(created_at)
                .updated_at(updated_at)
                .build();
    }
}

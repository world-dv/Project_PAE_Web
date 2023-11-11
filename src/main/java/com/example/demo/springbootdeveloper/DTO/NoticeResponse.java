package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Notice;
import lombok.Getter;

@Getter
public class NoticeResponse {

    private final Long id;
    private final String title;
    private final String content;

    public NoticeResponse(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
    }
}

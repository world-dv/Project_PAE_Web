package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Notice;
import lombok.Getter;

import java.sql.Date;

@Getter
public class NoticeResponseOne {

    private final Long id;
    private final String title;
    private final String content;
    private final Date date;

    public NoticeResponseOne(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.date = notice.getDate();
    }

}

package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Notice;
import lombok.Getter;

import java.sql.Date;

@Getter
public class NoticeResponseOne {

    public final String title;
    public final String content;
    public final Date date;

    public NoticeResponseOne(Notice notice) {
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.date = notice.getDate();
    }

}

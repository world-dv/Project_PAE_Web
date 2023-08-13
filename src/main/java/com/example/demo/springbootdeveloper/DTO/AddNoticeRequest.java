package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddNoticeRequest {

    private String title;
    private String content;
    private Date date;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Notice toEntity() {
        return Notice.builder()
                .title(title)
                .content(content)
                .date(date)
                .created_at(created_at)
                .updated_at(updated_at)
                .build();
    }
}

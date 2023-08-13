package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Info;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddInfoRequest {

    private String title;
    private String category;
    private String content;
    private Date date;
    private String url;
    private String img;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Info toEntity() {
        return Info.builder()
                .title(title)
                .category(category)
                .content(content)
                .date(date)
                .url(url)
                .img(img)
                .created_at(created_at)
                .updated_at(updated_at)
                .build();
    }
}

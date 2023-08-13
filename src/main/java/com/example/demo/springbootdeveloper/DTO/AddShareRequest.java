package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Share;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddShareRequest {

    private String title;
    private String category;
    private String content;
    private String img;
    private Date date;
    private String state;
    private String address;
    private Integer price;
    private String nickname;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Share toEntity() {
        return Share.builder()
                .title(title)
                .category(category)
                .content(content)
                .img(img)
                .date(date)
                .state(state)
                .address(address)
                .price(price)
                .nickname(nickname)
                .created_at(created_at)
                .updated_at(updated_at)
                .build();
    }
}

package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Share;
import lombok.Getter;

import java.sql.Date;

@Getter
public class ShareResponseOne {

    private final String title;
    private final String category;
    private final String content;
    private final String img;
    private final Date date;
    private final String state;
    private final String address;
    private final Integer price;
    private final String nickname;

    public ShareResponseOne(Share share) {
        this.title = share.getTitle();
        this.category = share.getCategory();
        this.content = share.getContent();
        this.img = share.getImg();
        this.date = share.getDate();
        this.state = share.getState();
        this.address = share.getAddress();
        this.price = share.getPrice();
        this.nickname = share.getNickname();
    }
}

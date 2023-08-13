package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Share;
import lombok.Getter;

@Getter
public class ShareResponse {

    private final String title;
    private final String category;
    private final String img;
    private final String state;
    private final Integer price;
    private final String nickname;

    public ShareResponse(Share share) {
        this.title = share.getTitle();
        this.category = share.getCategory();
        this.img = share.getImg();
        this.state = share.getState();
        this.price = share.getPrice();
        this.nickname = share.getNickname();
    }
}

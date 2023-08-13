package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Share_comment;
import lombok.Getter;

import java.sql.Date;

@Getter
public class ShareCommentResponse {

    private final long shareId;
    private final String nickname;
    private final String content;
    private final Date date;
    private final Integer pid;

    public ShareCommentResponse(Share_comment shareComment) {
        this.shareId = shareComment.getShareId();
        this.nickname = shareComment.getNickname();
        this.content = shareComment.getContent();
        this.date = shareComment.getDate();
        this.pid = shareComment.getPid();
    }
}

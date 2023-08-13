package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Share_comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddShareCommentRequest {

    private long share_id;
    private String content;
    private Date date;
    private String nickname;
    private Integer pid;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Share_comment toEntity() {
        return Share_comment.builder()
                .share_id(share_id)
                .content(content)
                .date(date)
                .nickname(nickname)
                .pid(pid)
                .created_at(created_at)
                .updated_at(updated_at)
                .build();
    }

}

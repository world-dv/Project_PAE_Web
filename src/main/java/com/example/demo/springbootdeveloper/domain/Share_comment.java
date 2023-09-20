package com.example.demo.springbootdeveloper.domain;

//import jakarta.persistence.*;
import javax.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Share_comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="share_comment_id", updatable = false)
    private Long id;

    @Column(name="ShareId")
    private long shareId;

    @Column(name="content", nullable = true)
    private String content;

    @Column(name="date", nullable = false)
    private Date date;

    @Column(name="nickname", nullable = false)
    private String nickname;

    @Column(name="pid", nullable = false)
    private Integer pid;

    @Column(name="created_at", nullable = false)
    private Timestamp created_at;

    @Column(name="updated_at", nullable = false)
    private Timestamp updated_at;

    /*
    @ManyToOne
    @JoinColumn(name="share_id")
    private Share share;
     */

    @Builder
    public Share_comment(long shareId, String content, Date date, String nickname,Integer pid, Timestamp created_at, Timestamp updated_at) {
        this.shareId = shareId;
        this.content = content;
        this.date = date;
        this.nickname = nickname;
        this.pid = pid;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void update(String content, Integer pid, Timestamp updated_at) {
        this.content = content;
        this.pid = pid;
        this.updated_at = updated_at;
    }
}

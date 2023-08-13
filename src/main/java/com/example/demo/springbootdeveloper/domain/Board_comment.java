package com.example.demo.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board_comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long board_comment_id;

    @Column(name="content", nullable = true)
    private String content;

    @Column(name="date", nullable = false)
    private Date date;

    @Column(name="nickname", nullable = false)
    private String nickname;

    @Column(name="created_at", nullable = false)
    private Timestamp created_at;

    @Column(name="updated_at", nullable = false)
    private Timestamp updated_at;

    /*
    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;
     */

    @Column(name="share_id", nullable = false)
    private Long share_id;

    @Builder
    public Board_comment(long share_id, String nickname, String content, Date date, Timestamp created_at, Timestamp updated_at) {
        this.share_id = share_id;
        this.nickname = nickname;
        this.content = content;
        this.date = date;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void update(long share_id, String nickname, String content, Timestamp updated_at) {
        this.share_id = share_id;
        this.nickname = nickname;
        this.content = content;
        this.updated_at = updated_at;
    }
}

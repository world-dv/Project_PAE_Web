package com.example.demo.springbootdeveloper.domain;

import jakarta.persistence.*;
//import javax.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long boardId;

    @Column(name="category", nullable = false)
    private String category;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="content", nullable = true)
    private String content;

    @Column(name="date", nullable = false)
    private Date date;

    /*
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
     */

    @Column(name="nickname", nullable = false)
    private String nickname;

    @Column(name="created_at", nullable = false)
    private Timestamp created_at;

    @Column(name="updated_at", nullable = false)
    private Timestamp updated_at;

    @Builder
    public Board(String title, String category, String content, Date date, String nickname, Timestamp created_at, Timestamp updated_at) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.date = date;
        this.nickname = nickname;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}

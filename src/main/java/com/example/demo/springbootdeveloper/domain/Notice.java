package com.example.demo.springbootdeveloper.domain;
//import jakarta.persistence.*;

import javax.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = true)
    private Long id;
    @Column(name="title", nullable = false)
    private String title;

    @Column(name="content", nullable = true)
    private String content;

    @Column(name="date", nullable = false)
    private Date date;

    @Column(name="created_at", nullable = false)
    private Timestamp created_at;

    @Column(name="updated_at", nullable = false)
    private Timestamp updated_at;

    @Builder
    public Notice(String title, String content, Date date, Timestamp created_at, Timestamp updated_at) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void update(String title, String content, Date date, Timestamp updated_at) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.updated_at = updated_at;
    }
}

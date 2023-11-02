package com.example.demo.springbootdeveloper.domain;

import jakarta.persistence.*;
//import javax.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="category", nullable = false)
    private String category;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="content", nullable = true)
    private String content;

    @Column(name="date", nullable = false)
    private Date date;

    @Column(name="url", nullable = false)
    private String url;

    @Column(name="img", nullable = false)
    private String img;

    @Column(name = "img2", nullable = false)
    private String img2;

    @Column(name = "img3", nullable = false)
    private String img3;

    @Column(name="created_at", nullable = false)
    private Timestamp created_at;

    @Column(name="updated_at", nullable = false)
    private Timestamp updated_at;

    @Builder
    public Info(String title, String category, String content, Date date, String url, String img, String img2, String img3, Timestamp created_at, Timestamp updated_at) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.date = date;
        this.url = url;
        this.img = img;
        this.img2 = img2;
        this.img3 = img3;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    public void update(String title, String category, String content, Date date, String url, String img, String img2, String img3, Timestamp updated_at) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.date = date;
        this.url = url;
        this.img = img;
        this.img2 = img2;
        this.img3 = img3;
        this.updated_at = updated_at;
    }
}

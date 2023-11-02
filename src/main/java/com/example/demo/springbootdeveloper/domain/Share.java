package com.example.demo.springbootdeveloper.domain;

import jakarta.persistence.*;
//import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long shareId;

    @Column(name="category", updatable = false)
    private String category;

    @Column(name="title", updatable = false)
    private String title;

    @Column(name="content", updatable = true)
    private String content;

    @Column(name="img", updatable = true)
    private String img;

    @Column(name = "img2", nullable = false)
    private String img2;

    @Column(name = "img3", nullable = false)
    private String img3;

    @Column(name="date", updatable = false)
    private Date date;

    @Column(name="state", updatable = false)
    private String state;

    @Column(name="address", updatable = true)
    private String address;

    @Column(name="price", updatable = false)
    private Integer price;

    /*
    @ManyToOne
    @JoinColumn(name="user_id", updatable = false)
    private User user;
     */

    @Column(name="nickname", updatable = false)
    private String nickname;

    @Column(name="created_at", updatable = false)
    private Timestamp created_at;

    @Column(name="updated_at", updatable = false)
    private Timestamp updated_at;

    @Builder
    public Share(String title, String category, String content, String img, String img2, String img3, Date date, String state, String address, Integer price, String nickname, Timestamp created_at, Timestamp updated_at) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.img = img;
        this.img2 = img2;
        this.img3 = img3;
        this.date = date;
        this.state = state;
        this.address = address;
        this.price = price;
        this.nickname = nickname;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}

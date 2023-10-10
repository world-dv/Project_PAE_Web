package com.example.demo.springbootdeveloper.domain;

import jakarta.persistence.*;
//import javax.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", updatable = false)
    private Long id;

    @Column(name="pw", nullable = false)
    private String pw;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="phone", nullable = false)
    private String phone;

    @Column(name="date", nullable = false)
    private Date date;

    @Column(name="helper", nullable = true)
    private boolean helper;

    @Column(name="gender", nullable = true)
    private boolean gender;

    @Column(name="user_nickname", nullable = false)
    private String nickname;

    @Column(name="location_x", nullable = false)
    private float location_x;

    @Column(name="location_y", nullable = false)
    private float location_y;

    @Column(name="created_at", nullable = false)
    private Timestamp created_at;

    @Column(name="updated_at", nullable = false)
    private Timestamp updated_at;

    @Builder
    public User(String pw, String name, String email, String address, String phone, Date date, boolean helper, boolean gender, String nickname, float location_x, float location_y, Timestamp created_at, Timestamp updated_at) {
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.helper = helper;
        this.gender = gender;
        this.nickname = nickname;
        this.location_x = location_x;
        this.location_y = location_y;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void update(String pw, String name, String email, String address, String phone, Date date, boolean helper, boolean gender, String nickname, float location_x, float location_y, Timestamp updated_at) {
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.helper = helper;
        this.gender = gender;
        this.nickname = nickname;
        this.location_x = location_x;
        this.location_y = location_y;
        this.updated_at = updated_at;
    }

    public void updatePw(String pw) {
        this.pw = pw;
    }
}

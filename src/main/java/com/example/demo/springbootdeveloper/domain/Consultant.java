package com.example.demo.springbootdeveloper.domain;

import jakarta.persistence.*;
//import javax.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="cost", nullable = false)
    private Integer cost;

    @Column(name="gender", nullable = false)
    private boolean gender;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="detail", nullable = true)
    private String detail;

    @Column(name="field", nullable = false)
    private String field;

    @Column(name="created_at", nullable = false)
    private Timestamp created_at;

    @Column(name="updated_at", nullable = false)
    private Timestamp updated_at;

    @Builder
    public Consultant(String name, Integer cost, boolean gender, String email, String detail, String field, Timestamp created_at, Timestamp updated_at) {
        this.name = name;
        this.cost = cost;
        this.gender = gender;
        this.email = email;
        this.detail = detail;
        this.field = field;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void update(String name, Integer cost, boolean gender, String email, String detail, String field, Timestamp updated_at) {
        this.name = name;
        this.cost = cost;
        this.gender = gender;
        this.email = email;
        this.detail = detail;
        this.field = field;
        this.updated_at = updated_at;
    }
}

package com.example.demo.springbootdeveloper.domain;

//import jakarta.persistence.*;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExtraContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "content", nullable = true)
    private String content;

    @Builder
    public ExtraContent(String category, String content) {
        this.category = category;
        this.content = content;
    }
}

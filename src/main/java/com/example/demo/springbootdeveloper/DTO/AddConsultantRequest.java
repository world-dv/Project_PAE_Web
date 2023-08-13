package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Consultant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddConsultantRequest {

    private String name;
    private Integer cost;
    private boolean gender;
    private String email;
    private String detail;
    private String field;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Consultant toEntity() {
        return Consultant.builder()
                .name(name)
                .cost(cost)
                .gender(gender)
                .email(email)
                .detail(detail)
                .field(field)
                .created_at(created_at)
                .updated_at(updated_at)
                .build();
    }
}

package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Consultant;
import lombok.Getter;

@Getter
public class ConsultantResponse {

    private final Long id;
    private final String name;
    private final Integer cost;
    private final boolean gender;
    private final String email;
    private final String detail;
    private final String field;

    public ConsultantResponse(Consultant consultant) {
        this.id = consultant.getId();
        this.name = consultant.getName();
        this.cost = consultant.getCost();
        this.gender = consultant.isGender();
        this.email = consultant.getEmail();
        this.detail = consultant.getDetail();
        this.field = consultant.getField();
    }
}

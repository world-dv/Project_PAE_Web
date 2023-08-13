package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Consultant;
import lombok.Getter;

@Getter
public class ConsultantResponseOne {

    private final String name;
    private final Integer cost;
    private final boolean gender;
    private final String email;
    private final String detail;
    private final String field;

    public ConsultantResponseOne(Consultant consultant) {
        this.name = consultant.getName();
        this.cost = consultant.getCost();
        this.gender = consultant.isGender();
        this.email = consultant.getEmail();
        this.detail = consultant.getDetail();
        this.field = consultant.getField();
    }
}
package com.example.demo.springbootdeveloper.DTO;

import com.example.demo.springbootdeveloper.domain.Consultant;
import lombok.Getter;

@Getter
public class ConsultantResponse {

    private final String name;
    private final Integer cost;
    private final boolean gender;
    private final String field;

    public ConsultantResponse(Consultant consultant) {
        this.name = consultant.getName();
        this.cost = consultant.getCost();
        this.gender = consultant.isGender();
        this.field = consultant.getField();
    }
}

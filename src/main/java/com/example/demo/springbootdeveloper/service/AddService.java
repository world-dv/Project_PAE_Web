package com.example.demo.springbootdeveloper.service;

import com.example.demo.springbootdeveloper.domain.Add;
import com.example.demo.springbootdeveloper.repository.AddRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddService {

    public final AddRespository addRespository;

    public Add findByCategory(String category) {
        Add add = addRespository.findByCategory(category);
        return add;
    }
}

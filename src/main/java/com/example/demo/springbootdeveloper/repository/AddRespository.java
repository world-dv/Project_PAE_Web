package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Add;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddRespository extends JpaRepository<Add, Long> {

    Add findByCategory(String category);
}

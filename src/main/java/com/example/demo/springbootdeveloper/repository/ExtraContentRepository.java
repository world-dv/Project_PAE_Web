package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.ExtraContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtraContentRepository extends JpaRepository<ExtraContent, Long> {

    ExtraContent findByCategory(String category);
}

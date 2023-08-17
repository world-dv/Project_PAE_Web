package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoRepository extends JpaRepository<Info, Long> {
    List<Info> findByCategory(String category);
}

package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
    List<Consultant> findByField(String cate);
}

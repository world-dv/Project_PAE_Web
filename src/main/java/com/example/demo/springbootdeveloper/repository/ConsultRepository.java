package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Consult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultRepository extends JpaRepository<Consult, Long> {
}

package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
}

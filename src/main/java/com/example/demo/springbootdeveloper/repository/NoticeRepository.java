package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}

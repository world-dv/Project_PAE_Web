package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Share_comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareCommentRepository extends JpaRepository<Share_comment, Long> {
}

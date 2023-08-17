package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Share_comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShareCommentRepository extends JpaRepository<Share_comment, Long> {
    List<Share_comment> findByShareId(long shareId);
    List<Share_comment> findByNickname(String nickname);
}

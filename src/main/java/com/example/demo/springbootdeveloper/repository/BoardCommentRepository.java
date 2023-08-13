package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Board_comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardCommentRepository extends JpaRepository<Board_comment, Long> {
    List<Board_comment> findByBoardId(long boardId);
}

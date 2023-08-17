package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findBoardByNickname(String nickname);
}

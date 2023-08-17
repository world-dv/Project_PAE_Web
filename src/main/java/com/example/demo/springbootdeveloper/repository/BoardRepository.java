package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findBoardByNickname(String nickname);
}

package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.DTO.UpdateBoardRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateShareRequest;
import com.example.demo.springbootdeveloper.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findBoardByNickname(String nickname);

    List<Board> findByEmail(String email);
    List<Board> findByCategory(String cate);
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Board b SET b.title = :#{#request.title}, b.category = :#{#request.category}, b.content = :#{#request.content}, b.nickname = :#{#request.nickname}, b.updated_at = :#{#request.updated_at} WHERE b.boardId = :boardId")
    int update(@Param("boardId") Long boardId, @Param("request") UpdateBoardRequest request);
}

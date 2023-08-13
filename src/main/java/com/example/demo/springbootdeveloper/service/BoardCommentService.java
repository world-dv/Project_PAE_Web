package com.example.demo.springbootdeveloper.service;

import com.example.demo.springbootdeveloper.DTO.AddBoardCommentRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateBoardCommentRequest;
import com.example.demo.springbootdeveloper.domain.Board_comment;
import com.example.demo.springbootdeveloper.repository.BoardCommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardCommentService {

    private final BoardCommentRepository boardCommentRepository;

    public Board_comment save(AddBoardCommentRequest request) {
        return boardCommentRepository.save(request.toEntity());
    }

    public void delete(long id) {
        boardCommentRepository.deleteById(id);
    }

    @Transactional
    public Board_comment update(long id, UpdateBoardCommentRequest request) {
        Board_comment boardComment = boardCommentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        boardComment.update(
            request.getContent(),
            request.getUpdated_at()
        );

        return boardComment;
    }

    public List<Board_comment> findByBoardId(long boardId) {
        List<Board_comment> boardComments = boardCommentRepository.findByBoardId(boardId);
        return boardComments;
    }
}

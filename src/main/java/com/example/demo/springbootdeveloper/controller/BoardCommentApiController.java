package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.AddBoardCommentRequest;
import com.example.demo.springbootdeveloper.DTO.BoardCommentResponse;
import com.example.demo.springbootdeveloper.DTO.UpdateBoardCommentRequest;
import com.example.demo.springbootdeveloper.domain.Board_comment;
import com.example.demo.springbootdeveloper.service.BoardCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class BoardCommentApiController {

    private final BoardCommentService boardCommentService;

    public BoardCommentApiController(BoardCommentService boardCommentService) {
        this.boardCommentService = boardCommentService;
    }

    @PostMapping("/api/boardComment")
    public ResponseEntity<Board_comment> addBoardComment(@RequestBody AddBoardCommentRequest request) {
        Board_comment savedBoardComment = boardCommentService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedBoardComment);
    }

    @DeleteMapping("/api/boardComment/{id}")
    public ResponseEntity<Void> deleteBoardComment(@PathVariable long id) {
        boardCommentService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/boardComment/{id}")
    public ResponseEntity<Board_comment> updateBoardComment(@PathVariable long id, @RequestBody UpdateBoardCommentRequest request) {
        Board_comment updatedBoardComment = boardCommentService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedBoardComment);
    }

    @GetMapping("/api/boardComments/{boardId}")
    public ResponseEntity<List<BoardCommentResponse>> findBoardComment(@PathVariable long boardId) {
        List<BoardCommentResponse> boardComments = boardCommentService.findByBoardId(boardId)
                .stream()
                .map(BoardCommentResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(boardComments);
    }

    @GetMapping("/api/boardComment/user/{nickname}")
    public ResponseEntity<List<BoardCommentResponse>> findBoardCommentByNickname(@PathVariable String nickname) {
        List<BoardCommentResponse> boardComments = boardCommentService.findByNickname(nickname)
                .stream()
                .map(BoardCommentResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(boardComments);
    }
}

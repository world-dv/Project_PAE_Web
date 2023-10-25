package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.AddBoardRequest;
import com.example.demo.springbootdeveloper.DTO.BoardResponse;
import com.example.demo.springbootdeveloper.DTO.BoardResponseOne;
import com.example.demo.springbootdeveloper.DTO.UpdateBoardRequest;
import com.example.demo.springbootdeveloper.domain.Board;
import com.example.demo.springbootdeveloper.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class BoardApiController {

    private final BoardService boardService;

    public BoardApiController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/api/board")
    public ResponseEntity<Board> addBoard(@RequestBody AddBoardRequest request) {
        Board savedBoard = boardService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedBoard);
    }

    @GetMapping("/api/boards")
    public ResponseEntity<List<BoardResponse>> findAllBoard() {
        List<BoardResponse> boards = boardService.findAll()
                .stream()
                .map(BoardResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(boards);
    }

    @GetMapping("/api/board/{id}")
    public ResponseEntity<BoardResponseOne> findUserBoardOne(@PathVariable long id) {
        Board boards = boardService.findById(id);
        return ResponseEntity.ok()
                .body(new BoardResponseOne(boards));
    }

    @GetMapping("/api/board/parenting")
    public ResponseEntity<List<BoardResponse>> findParentingInfo() {
        List<BoardResponse> paeBoards = boardService.findPaeInfo()
                .stream()
                .map(BoardResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(paeBoards);
    }

    @GetMapping("/api/board/daily")
    public ResponseEntity<List<BoardResponse>> findDailyInfo() {
        List<BoardResponse> dailyBoard = boardService.findDailyInfo()
                .stream()
                .map(BoardResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(dailyBoard);
    }

    @GetMapping("/api/board/user/{nickname}")
    public ResponseEntity<List<BoardResponse>> findBoardByUser(@PathVariable String nickname) {
        List<BoardResponse> boards = boardService.findByNickname(nickname)
                .stream()
                .map(BoardResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(boards);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable long id) {
        boardService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/board/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable long id, @RequestBody UpdateBoardRequest request) {
        Board updatedBoard = boardService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedBoard);
    }
}

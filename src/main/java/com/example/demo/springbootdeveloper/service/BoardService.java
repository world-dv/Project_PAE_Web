package com.example.demo.springbootdeveloper.service;

import com.example.demo.springbootdeveloper.DTO.AddBoardRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateBoardRequest;
import com.example.demo.springbootdeveloper.domain.Board;
import com.example.demo.springbootdeveloper.domain.User;
import com.example.demo.springbootdeveloper.repository.BoardRepository;
import com.example.demo.springbootdeveloper.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    private final UserRepository userRepository;

    public Board save(AddBoardRequest request) {

        User user = userRepository.findByNickname(request.getNickname());
        if(user != null) {
            return boardRepository.save(request.toEntity());
        } else {
            throw new IllegalArgumentException("not found " + request.getNickname());
        }
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findById(long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));
    }

    public void delete(long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public Board update(long id, UpdateBoardRequest request) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        board.update(
                request.getTitle(),
                request.getCategory(),
                request.getContent(),
                request.getDate(),
                request.getNickname(),
                request.getUpdated_at()
        );

        return board;
    }
}

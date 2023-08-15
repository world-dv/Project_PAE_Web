package com.example.demo.springbootdeveloper.service;

import com.example.demo.springbootdeveloper.DTO.AddUserRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateUserRequest;
import com.example.demo.springbootdeveloper.domain.User;
import com.example.demo.springbootdeveloper.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User save(AddUserRequest request) {
        return userRepository.save(request.toEntity());
    }

    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found + " + id));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User update(long id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        user.update(request.getPw(),
                request.getName(),
                request.getEmail(),
                request.getAddress(),
                request.getPhone(),
                request.getDate(),
                request.isHelper(),
                request.isGender(),
                request.getNickname(),
                request.getLocation_x(),
                request.getLocation_y(),
                request.getUpdated_at());
        return user;
    }

}

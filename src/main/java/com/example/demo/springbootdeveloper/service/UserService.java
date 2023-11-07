package com.example.demo.springbootdeveloper.service;

import com.example.demo.springbootdeveloper.DTO.AddUserRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateUserPwRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateUserRequest;
import com.example.demo.springbootdeveloper.DTO.UserResponse;
import com.example.demo.springbootdeveloper.domain.User;
import com.example.demo.springbootdeveloper.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    public User findByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User update(String email, UpdateUserRequest request) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new IllegalArgumentException("NOT FOUND " + email);
        }

        user.update(request.getPw(),
                request.getName(),
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

    @Transactional
    public User updatePw(String email, UpdateUserPwRequest request) {
        User user = userRepository.findByEmail(email);

        if(user != null) {
            user.updatePw(request.getPw());
            return user;
        } else {
            throw new IllegalArgumentException("user not found");
        }
    }
}

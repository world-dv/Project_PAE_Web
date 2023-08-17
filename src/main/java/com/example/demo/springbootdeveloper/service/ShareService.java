package com.example.demo.springbootdeveloper.service;

import com.example.demo.springbootdeveloper.DTO.AddShareRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateShareRequest;
import com.example.demo.springbootdeveloper.domain.Share;
import com.example.demo.springbootdeveloper.domain.User;
import com.example.demo.springbootdeveloper.repository.ShareRepository;
import com.example.demo.springbootdeveloper.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShareService {

    private final ShareRepository shareRepository;

    private final UserRepository userRepository;

    public Share save(AddShareRequest request) {

        User user = userRepository.findByNickname(request.getNickname());
        if(user != null) {
            return shareRepository.save(request.toEntity());
        } else {
            throw new IllegalArgumentException("not found " + request.getNickname());
        }
    }

    public List<Share> findAll() {
        return shareRepository.findAll();
    }

    public Share findById(long id) {
        return shareRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));
    }

    public List<Share> findByAddress(String address) {
        return shareRepository.findByAddress(address);
    }

    public List<Share> findByNickname(String nickname) {
        return shareRepository.findByNickname(nickname);
    }

    public void delete(long id) {
        shareRepository.deleteById(id);
    }

    @Transactional
    public Share update(long id, UpdateShareRequest request) {
        Share share = shareRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        share.update(request.getTitle(),
                request.getCategory(),
                request.getContent(),
                request.getImg(),
                request.getDate(),
                request.getState(),
                request.getAddress(),
                request.getPrice(),
                request.getNickname(),
                request.getUpdated_at()
        );

        return share;
    }
}

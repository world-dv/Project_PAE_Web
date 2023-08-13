package com.example.demo.springbootdeveloper.service;

import com.example.demo.springbootdeveloper.DTO.AddInfoRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateInfoRequest;
import com.example.demo.springbootdeveloper.domain.Info;
import com.example.demo.springbootdeveloper.repository.InfoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InfoService {

    private final InfoRepository infoRepository;

    public Info save(AddInfoRequest request) {
        return infoRepository.save(request.toEntity());
    }

    public List<Info> findAll() {
        return infoRepository.findAll();
    }

    public Info findById(long id) {
        return infoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));
    }

    public void delete(long id) {
        infoRepository.deleteById(id);
    }

    @Transactional
    public Info update(long id, UpdateInfoRequest request) {
        Info info = infoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        info.update(request.getTitle(),
                request.getCategory(),
                request.getContent(),
                request.getDate(),
                request.getUrl(),
                request.getImg(),
                request.getUpdated_at()
        );

        return info;
    }
}

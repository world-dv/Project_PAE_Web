package com.example.demo.springbootdeveloper.service;

import com.example.demo.springbootdeveloper.domain.ExtraContent;
import com.example.demo.springbootdeveloper.repository.ExtraContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExtraContentService {

    public final ExtraContentRepository addRepository;

    public ExtraContent findByCategory(String category) {
        ExtraContent ad = addRepository.findByCategory(category);
        return ad;
    }
}

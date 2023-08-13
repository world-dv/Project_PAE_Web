package com.example.demo.springbootdeveloper.service;

import com.example.demo.springbootdeveloper.DTO.AddNoticeRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateNoticeRequest;
import com.example.demo.springbootdeveloper.domain.Notice;
import com.example.demo.springbootdeveloper.repository.NoticeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public Notice save(AddNoticeRequest request) {
        return noticeRepository.save(request.toEntity());
    }

    public List<Notice> findAll() {
        return noticeRepository.findAll();
    }

    public Notice findById(long id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found + " + id));
    }

    public void delete(long id) {
        noticeRepository.deleteById(id);
    }

    @Transactional
    public Notice update(long id, UpdateNoticeRequest request) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        notice.update(
                request.getTitle(),
                request.getContent(),
                request.getDate(),
                request.getUpdated_at()
        );

        return notice;
    }
}

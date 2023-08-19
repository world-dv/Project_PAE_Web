package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.AddNoticeRequest;
import com.example.demo.springbootdeveloper.DTO.NoticeResponse;
import com.example.demo.springbootdeveloper.DTO.NoticeResponseOne;
import com.example.demo.springbootdeveloper.DTO.UpdateNoticeRequest;
import com.example.demo.springbootdeveloper.service.NoticeService;
import com.example.demo.springbootdeveloper.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {

    private final NoticeService noticeService;

    @PostMapping("/api/notice")
    public ResponseEntity<Notice> addNotice(@RequestBody AddNoticeRequest request) {
        Notice savedNotice = noticeService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedNotice);
    }

    @GetMapping("/api/notices")
    public ResponseEntity<List<NoticeResponse>> findAllNotice() {
        List<NoticeResponse> notices = noticeService.findAll()
                .stream()
                .map(NoticeResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(notices);
    }

    @GetMapping("/api/notice/{id}")
    public ResponseEntity<NoticeResponseOne> findNotice(@PathVariable long id) {
        Notice notice = noticeService.findById(id);

        return ResponseEntity.ok()
                .body(new NoticeResponseOne(notice));
    }

    @DeleteMapping("/api/notice/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable long id) {
        noticeService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/notice/{id}")
    public ResponseEntity<Notice> updateNotice(@PathVariable long id, @RequestBody UpdateNoticeRequest request) {
        Notice updatedNotice = noticeService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedNotice);
    }
}

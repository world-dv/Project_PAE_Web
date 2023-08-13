package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.AddShareCommentRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateShareCommentRequest;
import com.example.demo.springbootdeveloper.domain.Share_comment;
import com.example.demo.springbootdeveloper.service.ShareCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
public class ShareCommentApiController {

    private final ShareCommentService shareCommentService;

    public ShareCommentApiController(ShareCommentService shareCommentService) {
        this.shareCommentService = shareCommentService;
    }

    @PostMapping("/api/shareComment")
    public ResponseEntity<Share_comment> addShareComment(@RequestBody AddShareCommentRequest request) {
        Share_comment savedShareComment = shareCommentService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedShareComment);
    }

    @DeleteMapping("/api/shareComment/{id}")
    public ResponseEntity<Void> deleteShareComment(@PathVariable long id) {
        shareCommentService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/shareComment/{id}")
    public ResponseEntity<Share_comment> updateShareComment(@PathVariable long id, @RequestBody UpdateShareCommentRequest request) {
        Share_comment updatedShareComment = shareCommentService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedShareComment);
    }
}

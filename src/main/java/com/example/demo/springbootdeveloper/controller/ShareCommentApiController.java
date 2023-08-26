package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.AddShareCommentRequest;
import com.example.demo.springbootdeveloper.DTO.ShareCommentResponse;
import com.example.demo.springbootdeveloper.DTO.UpdateShareCommentRequest;
import com.example.demo.springbootdeveloper.domain.Share;
import com.example.demo.springbootdeveloper.domain.Share_comment;
import com.example.demo.springbootdeveloper.service.ShareCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/shareComments/{shareId}")
    public ResponseEntity<List<ShareCommentResponse>> findByShareId(@PathVariable long shareId) {
        List<ShareCommentResponse> shareComments = shareCommentService.findByShareId(shareId)
                .stream()
                .map(ShareCommentResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(shareComments);
    }

    @GetMapping("/api/shareComment/user/{nickname}")
    public ResponseEntity<List<ShareCommentResponse>> findByNickname(@PathVariable String nickname) {
        List<ShareCommentResponse> shareComments = shareCommentService.findByNickname(nickname)
                .stream()
                .map(ShareCommentResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(shareComments);
    }

    @GetMapping("/api/shareComment/{id}")
    public ResponseEntity<Share_comment> findShareCommentById(@PathVariable long id){
        Share_comment shareComment = shareCommentService.findById(id);

        return ResponseEntity.ok()
                .body(shareComment);
    }
}

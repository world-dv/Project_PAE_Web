package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.AddShareRequest;
import com.example.demo.springbootdeveloper.DTO.ShareResponse;
import com.example.demo.springbootdeveloper.DTO.ShareResponseOne;
import com.example.demo.springbootdeveloper.DTO.UpdateShareRequest;
import com.example.demo.springbootdeveloper.domain.Share;
import com.example.demo.springbootdeveloper.service.ShareService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ShareApiController {

    private final ShareService shareService;

    @PostMapping("/api/share")
    public ResponseEntity<Share> addShare(@RequestBody AddShareRequest request) {

        Share savedShare = shareService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedShare);
    }

    @GetMapping("/api/shares")
    public ResponseEntity<List<ShareResponse>> findAllShare() {
        List<ShareResponse> shares = shareService.findAll()
                .stream()
                .map(ShareResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(shares);
    }

    @GetMapping("/api/share/sale")
    public ResponseEntity<List<ShareResponse>> findSaleShare() {
        List<ShareResponse> shareResponses = shareService.findSale()
                .stream()
                .map(ShareResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(shareResponses);
    }

    @GetMapping("/api/share/sale-end")
    public ResponseEntity<List<ShareResponse>> findSaleShareEnd() {
        List<ShareResponse> shareResponses = shareService.findSaleEnd()
                .stream()
                .map(ShareResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(shareResponses);
    }

    @GetMapping("/api/share/sharing")
    public ResponseEntity<List<ShareResponse>> findSharing() {
        List<ShareResponse> shareResponses = shareService.findSharing()
                .stream()
                .map(ShareResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(shareResponses);
    }

    @GetMapping("/api/share/sharing-end")
    public ResponseEntity<List<ShareResponse>> findSharingEnd() {
        List<ShareResponse> shareResponses = shareService.findSharingEnd()
                .stream()
                .map(ShareResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(shareResponses);
    }

    @GetMapping("/api/share/{id}")
    public ResponseEntity<ShareResponseOne> findShare(@PathVariable long id) {
        Share share = shareService.findById(id);

        return ResponseEntity.ok()
                .body(new ShareResponseOne(share));
    }

    @GetMapping("/api/share/user/{nickname}")
    public ResponseEntity<List<ShareResponse>> findByNickname(@PathVariable String nickname) {
        List<ShareResponse> shares = shareService.findByNickname(nickname)
                .stream()
                .map(ShareResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(shares);
    }

    @GetMapping("/api/share/address/{address}")
    public ResponseEntity<List<ShareResponse>> findByAddress(@PathVariable String address) {
        List<ShareResponse> shares = shareService.findByAddress(address)
                .stream()
                .map(ShareResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(shares);
    }

    @DeleteMapping("/api/share/{id}")
    public ResponseEntity<Void> deleteShare(@PathVariable long id) {
        shareService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/share/{id}")
    public ResponseEntity<Share> updateShare(@PathVariable long id, @RequestBody UpdateShareRequest request) {
        Share updatedShare = shareService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedShare);
    }
}

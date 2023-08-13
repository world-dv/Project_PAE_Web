package com.example.demo.springbootdeveloper.service;

import com.example.demo.springbootdeveloper.DTO.AddShareCommentRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateShareCommentRequest;
import com.example.demo.springbootdeveloper.domain.Share_comment;
import com.example.demo.springbootdeveloper.repository.ShareCommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShareCommentService {

    private final ShareCommentRepository shareCommentRepository;

    public Share_comment save(AddShareCommentRequest request) {
        return shareCommentRepository.save(request.toEntity());
    }

    public void delete(long id) {
        shareCommentRepository.deleteById(id);
    }

    @Transactional
    public Share_comment update(long id, UpdateShareCommentRequest request) {
        Share_comment shareComment = shareCommentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        shareComment.update(request.getContent(),
                request.getPid(),
                request.getUpdated_at()
        );

        return shareComment;
    }
}

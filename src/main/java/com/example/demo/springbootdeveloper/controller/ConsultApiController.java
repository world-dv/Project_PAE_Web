package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.AddConsultRequest;
import com.example.demo.springbootdeveloper.DTO.ConsultResponse;
import com.example.demo.springbootdeveloper.DTO.ConsultResponseOne;
import com.example.demo.springbootdeveloper.DTO.UpdateConsultRequest;
import com.example.demo.springbootdeveloper.domain.Consult;
import com.example.demo.springbootdeveloper.service.ConsultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ConsultApiController {

    private final ConsultService consultService;

    @PostMapping("/api/consult")
    public ResponseEntity<Consult> addConsult(@RequestBody AddConsultRequest request) {
        Consult savedConsult = consultService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedConsult);
    }

    @GetMapping("/api/consults")
    public ResponseEntity<List<ConsultResponse>> findAllConsult() {
        List<ConsultResponse> consults = consultService.findAll()
                .stream()
                .map(ConsultResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(consults);
    }

    @GetMapping("/api/consult/{id}")
    public ResponseEntity<ConsultResponseOne> findConsult(@PathVariable long id) {
        Consult consult = consultService.findById(id);

        return ResponseEntity.ok()
                .body(new ConsultResponseOne(consult));
    }

    @GetMapping("/api/consult/category/{category}")
    public ResponseEntity<List<ConsultResponse>> findByCategory(String category) {
        List<ConsultResponse> consultResponses = consultService.findByCategory(category)
                .stream()
                .map(ConsultResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(consultResponses);
    }

    @DeleteMapping("/api/consult/{id}")
    public ResponseEntity<Void> deleteConsult(@PathVariable long id) {
        consultService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/consult/{id}")
    public ResponseEntity<Consult> updateConsult(@PathVariable long id, @RequestBody UpdateConsultRequest request) {
        Consult updatedConsult = consultService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedConsult);

    }
}

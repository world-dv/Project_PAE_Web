package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.*;
import com.example.demo.springbootdeveloper.domain.Consultant;
import com.example.demo.springbootdeveloper.service.ConsultantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ConsultantApiController {

    private final ConsultantService consultantService;

    @PostMapping("/api/consultant")
    public ResponseEntity<Consultant> addConsultant(@RequestBody AddConsultantRequest request) {
        Consultant savedConsultant = consultantService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedConsultant);
    }

    @GetMapping("/api/consultants")
    public ResponseEntity<List<ConsultantResponse>> findAllConsultant() {
        List<ConsultantResponse> consultants = consultantService.findAll()
                .stream()
                .map(ConsultantResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(consultants);
    }

    @GetMapping("/api/consultant/{id}")
    public ResponseEntity<ConsultantResponseOne> findConsultant(@PathVariable long id) {
        Consultant consultant = consultantService.findById(id);

        return ResponseEntity.ok()
                .body(new ConsultantResponseOne(consultant));
    }

    @DeleteMapping("/api/consultant/{id}")
    public ResponseEntity<Void> deleteConsultant(@PathVariable long id) {
        consultantService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/consultant/{id}")
    public ResponseEntity<Consultant> updateConsultant(@PathVariable long id, @RequestBody UpdateConsultantRequest request) {
        Consultant updatedConsultant = consultantService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedConsultant);
    }
}

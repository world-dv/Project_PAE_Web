package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.AddInfoRequest;
import com.example.demo.springbootdeveloper.DTO.InfoResponse;
import com.example.demo.springbootdeveloper.DTO.InfoResponseOne;
import com.example.demo.springbootdeveloper.domain.Info;
import com.example.demo.springbootdeveloper.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class InfoApiController {

    private final InfoService infoService;

    @PostMapping("/api/info")
    public ResponseEntity<Info> addInfo(@RequestBody AddInfoRequest request) {
        Info savedInfo = infoService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedInfo);
    }

    @GetMapping("/api/infos")
    public ResponseEntity<List<InfoResponse>> findAllInfo() {
        List<InfoResponse> info = infoService.findAll()
                .stream()
                .map(InfoResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(info);
    }

    @GetMapping("/api/info/{id}")
    public ResponseEntity<InfoResponseOne> findInfo(@PathVariable long id) {
        Info info = infoService.findById(id);

        return ResponseEntity.ok()
                .body(new InfoResponseOne(info));
    }

    @GetMapping("/api/info/category/{category}")
    public ResponseEntity<List<InfoResponse>> findByCategory(@PathVariable String category) {
        List<InfoResponse> infos = infoService.findByCategory(category)
                .stream()
                .map(InfoResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(infos);
    }

    @DeleteMapping("/api/info/{id}")
    public ResponseEntity<Void> deleteInfo(@PathVariable long id) {
        infoService.delete(id);

        return ResponseEntity.ok()
                .build();
    }
}

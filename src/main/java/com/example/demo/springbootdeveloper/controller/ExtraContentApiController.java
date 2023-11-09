package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.ExtraContentResponse;
import com.example.demo.springbootdeveloper.domain.ExtraContent;
import com.example.demo.springbootdeveloper.service.ExtraContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class ExtraContentApiController {

    public final ExtraContentService addService;

    public ExtraContentApiController(ExtraContentService addService) {
        this.addService = addService;
    }

    @GetMapping("/api/extracontent/{category}")
    public ResponseEntity<ExtraContentResponse> findByCategory(@PathVariable String category) {
        ExtraContent adds = addService.findByCategory(category);

        return ResponseEntity.ok()
                .body(new ExtraContentResponse(adds));
    }
}

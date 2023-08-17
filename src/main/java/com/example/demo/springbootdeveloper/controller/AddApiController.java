package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.DTO.AddResponse;
import com.example.demo.springbootdeveloper.domain.Add;
import com.example.demo.springbootdeveloper.service.AddService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class AddApiController {

    public final AddService addService;

    public AddApiController(AddService addService) {
        this.addService = addService;
    }

    @GetMapping("/api/add/{category}")
    public ResponseEntity<AddResponse> findByCategory(@PathVariable String category) {
        Add adds = addService.findByCategory(category);

        return ResponseEntity.ok()
                .body(new AddResponse(adds));
    }
}

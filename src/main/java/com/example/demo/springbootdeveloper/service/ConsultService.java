package com.example.demo.springbootdeveloper.service;

import com.example.demo.springbootdeveloper.DTO.AddConsultRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateConsultRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateConsultantRequest;
import com.example.demo.springbootdeveloper.domain.Consult;
import com.example.demo.springbootdeveloper.repository.ConsultRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConsultService {

    private final ConsultRepository consultRepository;

    public Consult save(AddConsultRequest request) {
        return consultRepository.save(request.toEntity());
    }

    public List<Consult> findAll() {
        return consultRepository.findAll();
    }

    public Consult findById(long id) {
        return consultRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));
    }

    public List<Consult> findByCategory(String category) {
        return consultRepository.findByCategory(category);
    }

    public void delete(long id) {
        consultRepository.deleteById(id);
    }

    @Transactional
    public Consult update(long id, UpdateConsultRequest request) {
        Consult consult = consultRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        consult.update(request.getTitle(),
                request.getCategory(),
                request.getContent(),
                request.getDate(),
                request.getUrl(),
                request.getImg(),
                request.getUpdated_at()
        );

        return consult;
    }
}

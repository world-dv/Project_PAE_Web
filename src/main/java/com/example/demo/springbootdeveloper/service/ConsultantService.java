package com.example.demo.springbootdeveloper.service;

import com.example.demo.springbootdeveloper.DTO.AddConsultantRequest;
import com.example.demo.springbootdeveloper.DTO.UpdateConsultantRequest;
import com.example.demo.springbootdeveloper.domain.Consultant;
import com.example.demo.springbootdeveloper.repository.ConsultantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConsultantService {

    private final ConsultantRepository consultantRepository;

    public Consultant save(AddConsultantRequest request) {
        return consultantRepository.save(request.toEntity());
    }

    public List<Consultant> findAll() {
        return consultantRepository.findAll();
    }

    public Consultant findById(long id) {
        return consultantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));
    }

    public List<Consultant> findParentingConsultant() {
        return consultantRepository.findByField("육아 상담");
    }

    public List<Consultant> findHomeConsultant() {
        return consultantRepository.findByField("가정 상담");
    }

    public void delete(long id) {
        consultantRepository.deleteById(id);
    }

    @Transactional
    public Consultant update(long id, UpdateConsultantRequest request) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        consultant.update(
                request.getName(),
                request.getCost(),
                request.isGender(),
                request.getEmail(),
                request.getDetail(),
                request.getField(),
                request.getUpdated_at()
        );

        return consultant;
    }
}

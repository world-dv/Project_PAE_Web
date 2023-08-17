package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Share;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareRepository extends JpaRepository<Share, Long> {

    Share findByNickname(String nickname);
}

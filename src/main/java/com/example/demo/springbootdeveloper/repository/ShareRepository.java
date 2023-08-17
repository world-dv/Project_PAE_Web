package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.Share;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShareRepository extends JpaRepository<Share, Long> {

    List<Share> findByNickname(String nickname);
    List<Share> findByAddress(String address);
}

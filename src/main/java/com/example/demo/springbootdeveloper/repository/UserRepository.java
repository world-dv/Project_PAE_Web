package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Boolean CheckByNickname(String nickname);
}

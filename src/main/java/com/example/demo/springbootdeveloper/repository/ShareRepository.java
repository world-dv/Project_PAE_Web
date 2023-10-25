package com.example.demo.springbootdeveloper.repository;

import com.example.demo.springbootdeveloper.DTO.UpdateShareRequest;
import com.example.demo.springbootdeveloper.domain.Share;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShareRepository extends JpaRepository<Share, Long> {

    List<Share> findByNickname(String nickname);
    List<Share> findByAddress(String address);
    List<Share> findByEmail(String email);
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Share s SET s.title = :#{#request.title}, s.category = :#{#request.category}, s.content = :#{#request.content}, s.img = :#{#request.img}, s.date = :#{#request.date}, s.state = :#{#request.state}, s.address = :#{#request.address}, s.price = :#{#request.price}, s.nickname = :#{#request.nickname}, s.updated_at = :#{#request.updated_at} WHERE s.shareId = :shareId")
    int update(@Param("shareId") Long shareId, @Param("request") UpdateShareRequest request);
}

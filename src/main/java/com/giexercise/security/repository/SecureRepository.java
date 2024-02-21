package com.giexercise.security.repository;

import com.giexercise.security.entity.SecureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecureRepository extends JpaRepository<SecureEntity, Integer> {
    SecureEntity findByUsername(String username);

    List<String> getAllUsernames();
}

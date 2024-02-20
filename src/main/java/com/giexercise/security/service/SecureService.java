package com.giexercise.security.service;

import com.giexercise.security.repository.SecureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecureService {
    private final SecureRepository secureRepository;

    @Autowired
    public SecureService(SecureRepository secureRepository) {
        this.secureRepository = secureRepository;
    }

    public boolean isValidUsername(String username) {
        return secureRepository.findByUsername(username) != null;
    }
}
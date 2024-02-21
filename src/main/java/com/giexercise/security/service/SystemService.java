package com.giexercise.security.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getSystemYear() {
        return "2024";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getSystemDate() {
        return "21-02-2024";
    }
}

package com.giexercise.security.service;

import com.giexercise.security.entity.SecureEntity;
import com.giexercise.security.repository.SecureRepository;
import com.giexercise.security.security.IsViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PreAuthorize("hasRole('ROLE_VIEWER')")
    public String getUsernameInUpperCase() {
        return getUsername().toUpperCase();
    }

    @PreAuthorize("hasRole('ROLE_VIEWER') or hasRole('ROLE_EDITOR')")
    public boolean isValidUsername3(String username) {
        return true;
    }

    @PreAuthorize("#username == authentication.principal.username")
    public String getMyRoles(String username) {
        return null;
    }

    @PostAuthorize("#username == authentication.principal.username")
    public String getMyRoles2(String username) {
        return null;
    }

    @PostAuthorize("returnObject.username == authentication.principal.nickName")
    public SecureEntity loadUserDetail(String username) {
        return secureRepository.findByUsername(username);
    }

    @PreFilter("filterObject != authentication.principal.username")
    public String joinUsernames(List<String> usernames) {
        return usernames.stream().collect(Collectors.joining(";"));
    }

    @PostFilter("filterObject != authentication.principal.username")
    public List<String> getAllUsernamesExceptCurrent() {
        return secureRepository.getAllUsernames();
    }

    @IsViewer
    public String getUsername4() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    @PreAuthorize("#username == authentication.principal.username")
    @PostAuthorize("returnObject.username == authentication.principal.nickName")
    public SecureEntity securedLoadUserDetail(String username) {
        return secureRepository.findByUsername(username);
    }

    public String getUsernameInLowerCase() {
        return SecurityContextHolder.getContext().getAuthentication().getName().toLowerCase();
    }
}

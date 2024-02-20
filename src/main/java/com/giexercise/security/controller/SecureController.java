package com.giexercise.security.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.stereotype.Controller;

@Controller
public class SecureController {
    @RolesAllowed("ROLE_VIEWER")
    public String getUsername2() {
        return null;
    }

    @RolesAllowed({ "ROLE_VIEWER", "ROLE_EDITOR" })
    public boolean isValidUsername2(String username) {
        return isValidUsername2(username);
    }
}

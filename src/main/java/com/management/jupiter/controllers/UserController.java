package com.management.jupiter.controllers;

import com.management.jupiter.models.User;
import com.management.jupiter.services.UserServices;
import com.management.jupiter.util.scanner.ScannerUtil;

public class UserController {

    private final ScannerUtil input;

    public UserController (ScannerUtil input) {
        this.input = input;
    }

    public User LoginController(String email, String password) throws Exception {

        // 2. DELEGAR AL SERVICE (No al Repository directamente)
        return UserServices.LoginService(email, password);

    }
}
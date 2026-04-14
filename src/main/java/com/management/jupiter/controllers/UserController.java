package com.management.jupiter.controllers;

import com.management.jupiter.models.User;
import com.management.jupiter.services.UserServices;

public class UserController {


    public User LoginController(String email, String password) throws Exception {

        // 2. DELEGAR AL SERVICE (No al Repository directamente)
        return UserServices.LoginService(email, password);

    }
}
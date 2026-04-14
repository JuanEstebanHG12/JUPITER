package com.management.jupiter.controllers;

import com.management.jupiter.models.User;
import com.management.jupiter.services.UserServices;
import com.management.jupiter.ui.auth.LoginUI;
import com.management.jupiter.util.scanner.ScannerUtil;

public class UserController {

    private final ScannerUtil input;

    public UserController (ScannerUtil input) {
        this.input = input;
    }

    public void LoginController() throws Exception {

        LoginUI.login();

        // 2. DELEGAR AL SERVICE (No al Repository directamente)
        User loggedUser = null;

        for (var i = 0; i<3; i++){

            try {
                // 1. CAPTURAR DATOS
                String email = input.readString("Email: ");

                String password = input.readString("Password: ");

                loggedUser = UserServices.LoginService(email, password);

                if (loggedUser != null) {
                    break;
                }

            } catch (Exception e) {

                System.err.println(e.getMessage());

            }

        }

        // 3. DECIDIR QUÉ MOSTRAR
        if (loggedUser != null) {
            System.out.println("\n Access Successfully." + loggedUser.getUsername());
        } else {
            System.out.println("\n Error: Access Deny.");
        }

    }
}
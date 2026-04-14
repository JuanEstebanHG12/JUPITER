package com.management.jupiter.views;

import com.management.jupiter.controllers.UserController;
import com.management.jupiter.models.User;
import com.management.jupiter.ui.auth.LoginUI;
import com.management.jupiter.util.scanner.ScannerUtil;

public class LoginView {

    private final ScannerUtil input;
    private final UserController controller;

    public LoginView(ScannerUtil input, UserController controller ){
        this.input = input;
        this.controller = controller;
    }

    public User login () {

        User loggedUser = null;

        for (int i = 3; i > 0; i --){

            LoginUI.login(i);

            try {

                String email = input.readString("Email: ");
                String password = input.readString("Password: ");

                loggedUser = controller.LoginController(email, password);

                // 3. DECIDIR QUÉ MOSTRAR
                if (loggedUser != null){
                    System.out.println("\n Access Successfully." + loggedUser.getUsername());
                    break;
                }else {
                    System.out.println("\n Error: Access Deny.");
                }

            }catch (Exception e) {

                System.err.println(e.getMessage());

            }

        }

        return loggedUser;

    }
}
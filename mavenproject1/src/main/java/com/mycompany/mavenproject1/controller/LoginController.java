package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.view.LoginView;
import com.mycompany.mavenproject1.view.MainView;

public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }
    
    public void handleLoginButton(String username, String password){
        if (username.equals("admin") && password.equals("admin")){
            view.setVisible(false);
            MainView view = new MainView();
            view.setVisible(true);
        }
    }
    
    
}

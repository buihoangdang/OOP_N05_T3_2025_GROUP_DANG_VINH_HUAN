package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.view.LoginView;

public class Mavenproject1 {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            LoginView view = new LoginView();
            view.setVisible(true);
        });
    }
}

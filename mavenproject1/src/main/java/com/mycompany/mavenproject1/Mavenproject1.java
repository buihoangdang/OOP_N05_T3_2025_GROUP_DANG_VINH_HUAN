package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.view.MainView;

public class Mavenproject1 {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            MainView view = new MainView();
            view.setVisible(true);
        });
    }

}

package org.anotherone661.blingblang.classes;

import java.awt.*;

public class URL {
    public static void openURL(String url) {
        try {
            Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (java.io.IOException e) {
            System.out.println("Error al abrir la URL: " + e.getMessage());
        }
    }
}

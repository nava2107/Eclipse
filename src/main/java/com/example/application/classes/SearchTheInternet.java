package com.example.application.classes;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SearchTheInternet {

    public void search(String query) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                String url = "https://www.google.com/search?q=" + query.replace(" ", "+");
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException("Failed to open browser: " + e.getMessage(), e);
            }
        } else {
            throw new UnsupportedOperationException("Desktop operations are not supported on this system.");
        }
    }
}

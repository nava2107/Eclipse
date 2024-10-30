package com.example.application.addons;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SearchButtons {

    public VerticalLayout createGoogleSearchComponent() {
        TextField searchField = new TextField("Enter search term");

        Button searchButton = new Button("Search on Google");

        searchButton.addClickListener(event -> {
            String query = searchField.getValue().trim();
            if (query.isEmpty()) {
                Notification.show("Please enter a search term.");
                return;
            }

            String googleSearchUrl = "https://www.google.com/search?q=" + query.replace(" ", "+");

            try {
                Desktop.getDesktop().browse(new URI(googleSearchUrl));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                Notification.show("Failed to open browser");
            }
        });

        VerticalLayout layout = new VerticalLayout(searchField, searchButton);
        return layout;
    }
}


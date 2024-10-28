package com.example.application.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;

public class RedirectCard extends Div {

    public RedirectCard(String title, String description, String targetRoute) {

        addClassName("card");
        setText(title + "\n" + description);


        addClickListener((ComponentEventListener<ClickEvent<Div>>) event ->
                UI.getCurrent().navigate(targetRoute)
        );
    }
}


package com.example.application.addons;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;

public class RedirectCard extends Div {

    public RedirectCard(String title, String description, String targetRoute) {

        addClassName("card");

        Span titleSpan = new Span(title);
        titleSpan.addClassName("card-title");
        add(titleSpan);

        Span descriptionSpan = new Span(description);
        descriptionSpan.addClassName("card-description");
        add(descriptionSpan);


        addClickListener((ComponentEventListener<ClickEvent<Div>>) event ->
                UI.getCurrent().navigate(targetRoute)
        );
    }
    public RedirectCard(String title, String description, String description2, String targetRoute) {

        addClassName("card");

        Span titleSpan = new Span(title);
        titleSpan.addClassName("card-title");
        add(titleSpan);

        Span descriptionSpan = new Span(description);
        descriptionSpan.addClassName("card-description");
        add(descriptionSpan);

        Span description2Span = new Span(description2);
        description2Span.addClassName("card-description2");
        add(description2Span);

        addClickListener((ComponentEventListener<ClickEvent<Div>>) event ->
                UI.getCurrent().navigate(targetRoute)
        );
    }
    public RedirectCard(String title, String description, String description2, String description3, String targetRoute) {

        addClassName("card");

        Span titleSpan = new Span(title);
        titleSpan.addClassName("card-title");
        add(titleSpan);

        Span descriptionSpan = new Span(description);
        descriptionSpan.addClassName("card-description");
        add(descriptionSpan);

        Span description2Span = new Span(description2);
        description2Span.addClassName("card-description2");
        add(description2Span);

        Span description3Span = new Span(description3);
        description3Span.addClassName("card-description3");
        add(description3Span);

        addClickListener((ComponentEventListener<ClickEvent<Div>>) event ->
                UI.getCurrent().navigate(targetRoute)
        );
    }


}


package com.example.application.views.test;

import com.example.application.addons.CustomIcon;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

@PageTitle("Empty")
@Route(value = "test-view")
public class TestView extends Div {
    public TestView() {
        addClassName("test-view");

        Div card = new Div();
        card.addClassName("cardT");

        Div background = new Div();
        background.addClassName("backgroundT");
        card.add(background);

        Div logo = new Div();
        logo.setText("Socials");
        logo.addClassName("logoTTT");
        card.add(logo);

        // Icon button links
        card.add(createIconLink("https://example.com/facebook", "rett-luna.png", "box1"));
        card.add(createIconLink("https://example.com/twitter", "rett-luna.png", "box2"));
        card.add(createIconLink("https://example.com/instagram", "rett-luna.png", "box3"));

        Div box4 = new Div();
        box4.addClassName("box4");
        card.add(box4);

        add(card);

        Button btn1 = new Button("Hover Me");
        btn1.addClassName("btn1");
        add(btn1);

        // Background shadow
        Div cardT = new Div();
        cardT.addClassName("cardTT");

        // Background shadow
        Div boxShadow = new Div();
        boxShadow.addClassName("boxshadowT");
        cardT.add(boxShadow);

        // Main content area
        Div mainT = new Div();
        mainT.addClassName("mainT");

        // Top, left side, right side decorative divs
        Div top = new Div();
        top.addClassName("topT");
        mainT.add(top);

        Div leftSide = new Div();
        leftSide.addClassName("left-side");
        mainT.add(leftSide);

        Div rightSide = new Div();
        rightSide.addClassName("right-side");
        mainT.add(rightSide);

        // Title div
        Span title = new Span("TITLE");
        title.addClassName("titleT");
        mainT.add(title);

        // Button container
        Div buttonContainer = new Div();
        buttonContainer.addClassName("button-containerT");

        // Add buttons with custom SVG icons
        buttonContainer.add(createIconButton(new CustomIcon("rett-luna.png")));
        buttonContainer.add(createIconButton(new CustomIcon("rett-luna.png")));
        buttonContainer.add(createIconButton(new CustomIcon("rett-luna.png"))); // Use your own SVG path here

        mainT.add(buttonContainer);
        cardT.add(mainT);
        add(cardT);
    }


    private Div createIconLink(String url, String iconPath, String boxClass) {
        Div box = new Div();
        box.addClassName(boxClass);

        StreamResource svgResource = new StreamResource(iconPath, () -> getClass().getResourceAsStream("/META-INF/resources/images/" + iconPath));
        Image iconImage = new Image(svgResource, "icon");
        iconImage.setClassName("svg");
        iconImage.getElement().getStyle().set("fill", "rgba(255, 255, 255, 0.8)");

        Button linkButton = new Button(iconImage);
        linkButton.addClickListener(event -> UI.getCurrent().getPage().executeJs("window.open($0, '_blank')", url));
        linkButton.addClassName("icon-buttonT");

        box.add(linkButton);
        return box;
    }
    private Button createIconButton(CustomIcon customIcon) {
        Button button = new Button(customIcon);
        button.addClassName("buttonT");
        return button;
    }
}

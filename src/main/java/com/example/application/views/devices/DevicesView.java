package com.example.application.views.devices;

import com.example.application.views.RedirectCard;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Devices")
@Route(value = "devices-view")
public class DevicesView extends Composite<VerticalLayout> {

    public DevicesView() {
        getContent().addClassName("devices-view");
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().getStyle().set("min-height", "100vh");

        Div container = new Div();
        container.addClassName("device-container");


        Div headerDevices = new Div();
        headerDevices.addClassName("header-devices");
        H1 titleDevices = new H1("Devices");
        Div backDiv = new Div();
        backDiv.addClassName("back-devices-div");
        Image icon = new Image("images/arrow-left.png", "back");
        icon.setWidth("25px");
        icon.addClassName("back-devices");
        icon.addClickListener((ComponentEventListener<ClickEvent<Image>>) click -> {
            getUI().ifPresent(ui -> ui.getPage().setLocation("http://localhost:60401"));
        });
        backDiv.add(icon);


        Div searchDiv = new Div();
        searchDiv.addClassName("input-wrapper");
        Image iconDI = new Image("/images/search.png", "search");
        iconDI.setWidth("25px");
        Button iconD = new Button(iconDI);
        iconD.addClassName("button-search");
        Input userS = new Input();
        userS.addClassName("user-input");
        searchDiv.add(iconD, userS);
        headerDevices.add(backDiv, titleDevices, searchDiv);

        container.add(headerDevices);


        Div securityDiv = createDeviceSection("Security Cameras", "View all");
        Div securityCards = new Div();
        securityCards.addClassName("device-cards");
        securityCards.add(
                new RedirectCard("Frontyard Camera", "ON", "security/frontyard"),
                new RedirectCard("Backyard Camera", "OFF", "security/backyard"),
                new RedirectCard("Garage Camera", "ON", "security/garage")
        );
        securityDiv.add(securityCards);
        container.add(securityDiv);


        Div lightingDiv = createDeviceSection("Lighting", "Manage Lights");
        Div lightingCards = new Div();
        lightingCards.addClassName("device-cards");
        lightingCards.add(
                new RedirectCard("Living Room Light", "ON", "lighting/living-room"),
                new RedirectCard("Bedroom Light", "OFF", "lighting/bedroom"),
                new RedirectCard("Kitchen Light", "ON", "lighting/kitchen")
        );
        lightingDiv.add(lightingCards);
        container.add(lightingDiv);

        Div rooms = new Div();
        rooms.setId("room-section");
        rooms.addClassName("rooms-div");
        H1 roomH1 = new H1("Your Rooms");
        Paragraph roomP = new Paragraph("Add room +");
        rooms.add(roomH1, roomP);
        container.add(rooms);

        Div officeDiv = createDeviceSection("Office Devices", "Manage Devices");
        Div officeCards = new Div();
        officeCards.addClassName("device-cards");
        officeCards.add(
                new RedirectCard("Office Desk Lamp", "Adjustable Light", "ON", "office/desk-lamp"),
                new RedirectCard("Printer", "Status: Ready", "Low Ink", "office/printer"),
                new RedirectCard("Monitor", "Power Saver Mode", "Connected", "Main Display", "office/monitor")
        );
        officeDiv.add(officeCards);
        container.add(officeDiv);


        Div livingRoomDiv = createDeviceSection("Living Room Devices", "Control Devices");
        Div livingRoomCards = new Div();
        livingRoomCards.addClassName("device-cards");
        livingRoomCards.add(
                new RedirectCard("TV", "Status: OFF", "living-room/tv"),
                new RedirectCard("Sound System", "Volume: 50%", "Bass Boost ON", "living-room/sound-system"),
                new RedirectCard("Air Purifier", "Running", "Mode: Auto", "Fan Speed: Medium", "living-room/air-purifier")
        );
        livingRoomDiv.add(livingRoomCards);
        container.add(livingRoomDiv);


        getContent().add(container);
    }


    private Div createDeviceSection(String titleText, String linkText) {
        Div sectionDiv = new Div();
        sectionDiv.addClassName("device-section");

        H2 title = new H2(titleText);
        Paragraph viewLink = new Paragraph(linkText);
        viewLink.addClassName("view-link");

        sectionDiv.add(title, viewLink);
        return sectionDiv;
    }
}

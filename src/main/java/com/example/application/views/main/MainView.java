package com.example.application.views.main;

import com.example.application.addons.RedirectCard;

import java.awt.*;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;

@PageTitle("My View")
@Menu(icon = "line-awesome/svg/pencil-ruler-solid.svg", order = 0)
@Route("main-view")
public class MainView extends Composite<VerticalLayout> {

    public MainView() {

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().getStyle().set("min-height", "100vh");


        this.addClassName("main-view");


        QueryParameters queryParameters = UI.getCurrent().getInternals().getActiveViewLocation().getQueryParameters();
        Map<String, List<String>> parameters = queryParameters.getParameters();

        if (parameters.containsKey("verification")) {
            String verificationStatus = parameters.get("verification").get(0);
            if ("success".equals(verificationStatus)) {
                Notification.show("Your account has been successfully verified!", 3000, Notification.Position.MIDDLE);
            } else if ("failed".equals(verificationStatus)) {
                Notification.show("Verification failed. Invalid or expired link.", 3000, Notification.Position.MIDDLE);
            }
        }

        Div container = new Div();
        container.addClassName("div-main");
        getContent().add(container);

        Div logo = new Div();
        logo.addClassName("logo");
        H1 eclipse = new H1("Eclipse");
        H1 eclipse2 = new H1("Eclipse");
        eclipse.addClassName("top");
        eclipse2.addClassName("bottom");
        logo.add(eclipse,eclipse2);
        container.add(logo);


        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Add Device");
        dialog.setWidth("15rem");
        dialog.setHeight("15rem");

        Button saveButton = new Button("Save", e -> dialog.close());
        Button cancelButton = new Button("Cancel", e -> dialog.close());
        dialog.getFooter().add(cancelButton);
        dialog.getFooter().add(saveButton);

        Dialog dialog2 = new Dialog();
        dialog2.setHeaderTitle("Searching Device");
        dialog2.setWidth("15rem");
        dialog2.setHeight("15rem");
        Button saveButton2 = new Button("Save", e -> dialog2.close());
        Button cancelButton2 = new Button("Cancel", e -> dialog2.close());
        dialog2.getFooter().add(cancelButton2);
        dialog2.getFooter().add(saveButton2);

        //meny bar
        MenuBar menuBar = new MenuBar();
        menuBar.setWidth("min-content");
        setMenuSampleData(menuBar, dialog, dialog2);
        menuBar.setClassName("menu-bar");


        Avatar avatar2 = new Avatar();
        avatar2.addClassName("avatar-main");
        avatar2.setName("Firstname Lastname");
        Button avatarbutton = new Button(avatar2);
        avatarbutton.addClassName("avatar-button");
        avatarbutton.addClickListener(event ->{
            getUI().ifPresent(ui -> ui.getPage().setLocation("http://localhost:60401/user-view"));
        });

        TextField questionField = new TextField("");
        questionField.setPlaceholder("Search the internet...");
        questionField.setWidth("300px");
        questionField.setClassName("ask-luna");

        Div wholeTop = new Div();
        wholeTop.addClassName("whole-top");
        container.add(wholeTop);

        Div filter = new Div();
        filter.addClassName("filter");
        wholeTop.add(filter);

        Div topMain = new Div();
        topMain.setClassName("top-main");
        topMain.setWidth("100%");
        topMain.add(menuBar, questionField, avatarbutton);
        wholeTop.add(topMain);

        Div background = new Div();
        background.setClassName("background");
        H3 prod = new H3();
        prod.setText("Products for you");
        prod.setClassName("text-main");

        Div recommendations = new Div();
        recommendations.setClassName("recommendations");

        recommendations.setWidth("100%");

        for (int i = 1; i <= 5; i++) {
            int productIndex = i;
            String imageUrl = "https://via.placeholder.com/150?text=Product+" + i;
            Image productImage = new Image(imageUrl, "Product " + i);
            productImage.setWidth("auto");
            productImage.setMinHeight("100px");
            productImage.setHeight("100%");


            productImage.getElement().addEventListener("click", event -> {

                System.out.println("Product " + productIndex + " clicked!");

            });

            recommendations.add(productImage);
        }

        Div products = new Div();
        products.setClassName("products");
        products.add(prod);



        Button buttonPrimary2 = new Button("Search Devices", e -> dialog2.open());

        Button buttonPrimary4 = new Button("My Devices");
        buttonPrimary4.addClickListener(event ->{
            getUI().ifPresent(ui -> ui.getPage().setLocation("http://localhost:60401/devices-view"));
        });

        Button buttonPrimary6 = new Button("Add manually", e -> dialog.open());
        buttonPrimary2.setWidth("min-content");
        buttonPrimary4.setWidth("min-content");
        buttonPrimary6.setWidth("min-content");



        buttonPrimary2.setClassName("search-button-main");
        buttonPrimary4.setClassName("devices-button-main");
        buttonPrimary6.setClassName("manual-button-main");

        Div buttonsMain = new Div();
        buttonsMain.setClassName("buttons-main");
        buttonsMain.add(buttonPrimary2, buttonPrimary4, buttonPrimary6);

        wholeTop.add(products, recommendations, dialog,buttonsMain);
        Div emptyDiv = new Div();
        emptyDiv.addClassName("empty");
        container.add(emptyDiv);


        Div quickMain = new Div();
        quickMain.addClassName("room-quick-main");

        Div upperQuick = new Div();
        upperQuick.addClassName("upper-room-quick-main");
        upperQuick.addClickListener(event ->{
            getUI().ifPresent(ui -> ui.getPage().setLocation("http://localhost:60401/devices-view#room-section"));
        });

        H3 yourRooms = new H3("Your Rooms");
        yourRooms.addClassName("quick-action-h3");
        Image icon = new Image("/images/arrow-right.png", "-->");
        icon.setWidth("20px");
        upperQuick.add(yourRooms, icon);
        quickMain.add(upperQuick);

        Div roomBottom = new Div();
        roomBottom.addClassName("top-rooms");

        RedirectCard room = new RedirectCard("Kitchen", "Tap to modify", "test-view");
        room.addClassName("room");
        RedirectCard room2 = new RedirectCard("Bedroom", "Tap to modify", "test-view");
        room2.addClassName("room");
        roomBottom.add(room, room2);
        quickMain.add(roomBottom);

        Div lowerQuick = new Div();
        lowerQuick.addClassName("lower-room-quick-main");
        lowerQuick.addClickListener(event ->{
            getUI().ifPresent(ui -> ui.getPage().setLocation("http://localhost:60401/devices-view"));
        });

        H3 suggestedDevices = new H3("Suggested Devices");
        suggestedDevices.addClassName("quick-action-h3");
        Image icon2 = new Image("/images/arrow-right.png", "-->");
        icon2.setWidth("20px");
        lowerQuick.add(suggestedDevices, icon2);
        quickMain.add(lowerQuick);

        Div deviceBottom = new Div();
        deviceBottom.addClassName("device-bottom");

        RedirectCard device = new RedirectCard("Thermo", "20C", "Tap to modify", "test-view");
        device.addClassName("room");
        RedirectCard device2 = new RedirectCard("Light 1", "ON" , "Tap to modify", "test-view");
        device2.addClassName("room");
        deviceBottom.add(device, device2);
        quickMain.add(deviceBottom);

        container.add(quickMain);
        Div luna = new Div();
        luna.setClassName("luna-main");
        Image lunaImage = new Image("/images/rett-luna.png", "Luna");

        lunaImage.addClickListener((ComponentEventListener<ClickEvent<Image>>) click -> {
            getUI().ifPresent(ui -> ui.getPage().setLocation("http://localhost:60401/luna-view"));
        });

        lunaImage.setClassName("luna-image-main");
        Div lunaBackground = new Div();
        lunaBackground.addClassName("background");

        lunaBackground.add(lunaImage);
        luna.add(lunaBackground);
        container.add(luna);

        Div footerMain = new Div();
        container.add(footerMain);

    }


    private void setMenuSampleData(MenuBar menuBar, Dialog dialog, Dialog dialog2) {
        Image menuImage = new Image("/images/menu-.png", "Menu");
        menuImage.addClassName("menu-img");


        MenuItem more = menuBar.addItem(menuImage);

        SubMenu shareSubMenu = more.getSubMenu();
        MenuItem onSocialMedia = shareSubMenu.addItem("Devices");
        SubMenu socialMediaSubMenu = onSocialMedia.getSubMenu();
        socialMediaSubMenu.addItem("My devices").addClickListener((ComponentEventListener<ClickEvent<MenuItem>>) click ->
                getUI().ifPresent(ui -> ui.getPage().setLocation("http://localhost:60401/devices-view")));
        socialMediaSubMenu.addItem("Add devices", e -> dialog.open());
        socialMediaSubMenu.addItem("Scan for devices", e -> dialog2.open());
        shareSubMenu.addItem("Account");
        shareSubMenu.addItem("Help");
    }
}

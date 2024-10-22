package com.example.application.views.main;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;
import java.awt.*;
import java.util.TimerTask;

@PageTitle("My View")
@Menu(icon = "line-awesome/svg/pencil-ruler-solid.svg", order = 0)
@Route("main-view")
public class MainView extends Composite<VerticalLayout> {

    public MainView() {

        this.addClassName("main-view");
        this.getElement().getStyle().set("background-color", "rgba(1, 1, 1, 0.5)");
        this.getElement().getStyle().setWidth("100%");
        this.getElement().getStyle().set("height", "100vh");

        Div container = new Div();
        container.getElement().getStyle().set("height", "100vh");
        container.getElement().getStyle().set("width", "100%");
        container.addClassName("div-background-general");
        getContent().add(container);

        //meny bar
        MenuBar menuBar = new MenuBar();
        menuBar.setWidth("min-content");
        setMenuSampleData(menuBar);
        menuBar.setClassName("menu-bar");

        Avatar avatar2 = new Avatar();
        avatar2.setName("Firstname Lastname");

        TextField questionField = new TextField("");
        questionField.setPlaceholder("Type your question here...");
        questionField.setWidth("300px");
        questionField.getStyle().set("color", "#ff0000");
        questionField.setClassName("ask-luna");

        Div topMain = new Div();
        topMain.setClassName("top-main");
        topMain.setWidth("100%");
        topMain.setHeight("10%");
        topMain.add(menuBar, questionField, avatar2);
        container.add(topMain);

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

        container.add(products, recommendations);


        Button buttonPrimary2 = new Button();
        Button buttonPrimary4 = new Button();
        Button buttonPrimary6 = new Button();
        buttonPrimary2.setText("Search devices");
        buttonPrimary2.setWidth("min-content");
        buttonPrimary4.setText("My devices");
        buttonPrimary4.setWidth("min-content");
        buttonPrimary6.setText("Add manually");
        buttonPrimary6.setWidth("min-content");
        buttonPrimary2.setClassName("search-button-main");
        buttonPrimary4.setClassName("devices-button-main");
        buttonPrimary6.setClassName("manual-button-main");

        Div buttonsMain = new Div();
        buttonsMain.setClassName("buttons-main");
        buttonsMain.add(buttonPrimary2, buttonPrimary4, buttonPrimary6);

        Div pulsContainer = new Div();
        pulsContainer.setClassName("puls-container");

        Image pulsImage = new Image("/images/devices.png", "Search");
        pulsImage.setClassName("puls-image");

        Div imagePuls = new Div();
        imagePuls.setClassName("image-puls");
        imagePuls.add(pulsImage);
        imagePuls.add(pulsContainer);

        Div mainDiv = new Div();
        mainDiv.setClassName("main-div");
        mainDiv.add(buttonsMain,imagePuls);

        container.add(mainDiv);

        Div luna = new Div();
        luna.setClassName("luna-main");
        Image lunaImage = new Image("/images/luna.png", "Luna");
        lunaImage.setClassName("luna-image-main");
        luna.add(lunaImage);
        container.add(luna);

        getContent().setWidth("100%");
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");


    }

    private void setMenuSampleData(MenuBar menuBar) {
        Image menuImage = new Image("/images/menu-bar.png", "Menu");
        menuImage.setWidth("24px");
        menuImage.setHeight("24px");

        MenuItem more = menuBar.addItem(menuImage);

        SubMenu shareSubMenu = more.getSubMenu();
        MenuItem onSocialMedia = shareSubMenu.addItem("Devices");
        SubMenu socialMediaSubMenu = onSocialMedia.getSubMenu();
        socialMediaSubMenu.addItem("My devices");
        socialMediaSubMenu.addItem("Add devices");
        socialMediaSubMenu.addItem("Scan for devices");
        shareSubMenu.addItem("Account");
        shareSubMenu.addItem("Help");
    }

}

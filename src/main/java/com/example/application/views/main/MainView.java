package com.example.application.views.main;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
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
import org.apache.coyote.http11.Http11InputBuffer;

@PageTitle("My View")
@Menu(icon = "line-awesome/svg/pencil-ruler-solid.svg", order = 0)
@Route("main-view")
public class MainView extends Composite<VerticalLayout> {

    public MainView() {

        this.addClassName("main-view");

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

        Div wholeTop = new Div();
        wholeTop.addClassName("whole-top");
        container.add(wholeTop);

        Div filter = new Div();
        filter.addClassName("filter");
        wholeTop.add(filter);

        Div topMain = new Div();
        topMain.setClassName("top-main");
        topMain.setWidth("100%");
        topMain.add(menuBar, questionField, avatar2);
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

        wholeTop.add(products, recommendations, buttonsMain);


        Div pulses = new Div();
        pulses.setClassName("pulses");


        Image pulsImage = new Image("/images/devices.png", "Search");
        pulsImage.setClassName("device-image");

        Div pulsContainer1 = new Div();
        pulsContainer1.setClassName("puls-container");
        pulsContainer1.add(pulsImage);
        pulsContainer1.add(pulses);

        Div mainDiv = new Div();
        mainDiv.setClassName("main-div");
        mainDiv.add(pulsContainer1);

        container.add(mainDiv);
        Div emptyDiv = new Div();
        emptyDiv.addClassName("empty");
        container.add(emptyDiv);

        Div quickMain = new Div();
        quickMain.addClassName("quick-main");

        Div upperQuick = new Div();
        upperQuick.addClassName("upper-quick-main");

        H3 quickAct = new H3("Devices quick action");
        quickAct.addClassName("quick-action-h3");
        H3 icon = new H3("-->");
        upperQuick.add(quickAct, icon);
        quickMain.add(upperQuick);


        Div bottomQuick = new Div();
        bottomQuick.addClassName("bottom-quick");
        Button top41 = new Button("Thermo");
        top41.setClassName("quick");
        Button top42 = new Button("Light 1");
        top42.setClassName("quick");
        Button top43 = new Button("Light 2");
        top43.setClassName("quick");
        Button top44 = new Button("Air Quality");
        top44.setClassName("quick");
        bottomQuick.add(top41, top42, top43, top44);
        quickMain.add(bottomQuick);
        container.add(quickMain);



        Div luna = new Div();
        luna.setClassName("luna-main");
        Image lunaImage = new Image("/images/rett-luna.png", "Luna");
        lunaImage.setClassName("luna-image-main");
        Div lunaBackground = new Div();
        lunaBackground.addClassName("background");
        lunaBackground.add(lunaImage);
        luna.add(lunaBackground);
        container.add(luna);

        getContent().setWidth("100%");
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
    }



    private void setMenuSampleData(MenuBar menuBar) {
        Image menuImage = new Image("/images/menu-.png", "Menu");
        menuImage.addClassName("menu-img");
//        menuImage.setWidth("24px");
//        menuImage.setHeight("24px");

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

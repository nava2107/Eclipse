package com.example.application.views.test;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Empty")
@Menu(icon = "line-awesome/svg/file.svg", order = 0)
@Route(value = "test-view")
public class TestView extends Composite<VerticalLayout> {
    public TestView() {
        this.addClassName("test-view");

        Div container = new Div();
        container.getElement().getStyle().set("height", "100vh");
        container.getElement().getStyle().set("width", "100%");
        container.addClassName("div-test");


        Div title = new Div();
        H1 create = new H1("Create Account");
        title.add(create);

        Div moon = new Div();
        moon.addClassName("moon");
        Div moon1 = new Div();
        Div moon2 = new Div();
        Div moon3 = new Div();
        Div moon4 = new Div();
        Div moon5 = new Div();
        Div moon6 = new Div();
        Div moon7 = new Div();

        moon.add(moon1,moon2,moon3,moon4,moon5, moon7, moon6);

        container.add(title, moon);
        getContent().add(container);





    }
}

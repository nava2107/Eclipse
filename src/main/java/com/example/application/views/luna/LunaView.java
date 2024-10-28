package com.example.application.views.luna;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Empty")
@Menu(icon = "line-awesome/svg/file.svg", order = 0)
@Route(value = "luna-view")
public class LunaView extends Composite<VerticalLayout> {
    public LunaView() {
        this.addClassName("test-view");


    }
}

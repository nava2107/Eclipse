package com.example.application.views.devices;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Empty")
@Menu(icon = "line-awesome/svg/file.svg", order = 0)
@Route(value = "devices-view")
public class DevicesView extends Composite<VerticalLayout> {
    public DevicesView() {
        this.addClassName("test-view");


    }
}

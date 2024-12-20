package com.example.application.addons;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.dom.Element;

@Tag("span")
public class CustomIcon extends Component {

    public CustomIcon(String pngPath) {
        Element pngElement = new Element("png");
        pngElement.setAttribute("width", "24");
        pngElement.setAttribute("height", "24");
        pngElement.setAttribute("viewBox", "0 0 24 24");
        pngElement.setAttribute("fill", "none");
        pngElement.setAttribute("stroke", "currentColor");
        pngElement.setAttribute("stroke-width", "2");
        pngElement.setAttribute("stroke-linecap", "round");
        pngElement.setAttribute("stroke-linejoin", "round");

        Element pathElement = new Element("path");
        pathElement.setAttribute("d", pngPath);
        pngElement.appendChild(pathElement);

        getElement().appendChild(pngElement);
    }
}


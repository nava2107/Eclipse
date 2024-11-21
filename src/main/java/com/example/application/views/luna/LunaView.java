package com.example.application.views.luna;

import com.example.application.classes.SimpleChatbot;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@PageTitle("Luna ChatBot")
@Route(value = "luna-view")
public class LunaView extends Composite<VerticalLayout> {

    private final SimpleChatbot simpleChatbot;
    private TextField messageField;
    private Div chatArea;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();


    @Autowired
    public LunaView(SimpleChatbot simpleChatbot) {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().getStyle().set("min-height", "100vh");

        this.simpleChatbot = simpleChatbot;

        this.addClassName("luna-chat-view");

        Div container = new Div();
        container.getElement().getStyle().set("height", "100vh");
        container.getElement().getStyle().set("width", "100%");
        container.addClassName("div-luna");

        Div headDivLuna = new Div();
        headDivLuna.addClassName("headerDivLuna");

        Image backLuna = new Image("/images/arrow-left.png", "back");
        backLuna.addClickListener((ComponentEventListener<ClickEvent<Image>>) click -> {
            getUI().ifPresent(ui -> ui.getPage().setLocation("http://localhost:60401/main-view"));
        });
        backLuna.addClassName("go-back-luna");
        backLuna.setWidth("25px");
        container.add(backLuna);


        Span titleLuna = new Span();
        titleLuna.addClassName("titleLuna");

        Image lunaImageLuna = new Image("/images/rett-luna.png", "Luna");
        lunaImageLuna.setWidth("35px");
        lunaImageLuna.setHeight("35px");
        H1 headerLuna = new H1("Luna the chatbot");
        headerLuna.addClassName("lunaheader");

        titleLuna.add(lunaImageLuna, headerLuna);
        headDivLuna.add(titleLuna);
        Div backgroundLuna = new Div();
        backgroundLuna.addClassName("backgroundLuna");
        headDivLuna.add(titleLuna,backgroundLuna);

        container.add(headDivLuna);

        Div chatAreaOuter = new Div();
        chatAreaOuter.addClassName("chat-area-outer");
        chatArea = new Div();
        chatArea.addClassName("chat-area");


        addChatMessage("Hei! Hvordan kan jeg hjelpe deg i dag? " +
                "\nJeg er fortsatt under utvikling. " +
                "\nAkkurat nå kan jeg svare på noen enkle spørsmål om appen.\n", "bot");


        messageField = new TextField();
        messageField.setPlaceholder("Send en melding til Luna...");
        messageField.addClassName("message-field");

        Button sendButton = new Button("Send", event -> sendMessage());
        sendButton.addClassName("sendLunaAsk");
        messageField.addKeyPressListener(Key.ENTER, event -> sendMessage());

        Div before = new Div();
        before.addClassName("beforeLuna");
        Div after = new Div();
        after.addClassName("afterLuna");

        Div bottomLuna = new Div();
        bottomLuna.addClassName("bottomLunaDiv");
        bottomLuna.add(messageField, sendButton);
        chatArea.add(bottomLuna);

        chatAreaOuter.add(before, chatArea, after);
        container.add(chatAreaOuter);
        getContent().add(container);

    }

    private void sendMessage() {
        String userMessage = messageField.getValue();
        if (!userMessage.isEmpty()) {
            addChatMessage(userMessage, "user");
            messageField.clear();

            String botResponse = simpleChatbot.getResponse(userMessage);
            addChatMessage(botResponse, "bot");
            chatArea.getElement().executeJs("this.scrollTop = this.scrollHeight;");

        }
    }

    private void addChatMessage(String message, String sender) {
        Span messageBubble = new Span(message);
        messageBubble.addClassName("message-bubble");

        if ("bot".equals(sender)) {
            messageBubble.addClassName("bot-message");
        } else {
            messageBubble.addClassName("user-message");
        }
        chatArea.add(messageBubble);
    }
}

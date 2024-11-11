package com.example.application.views.luna;

import com.example.application.classes.SimpleChatbot;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Luna Chatbot")
@Route(value = "luna-view")
public class LunaView extends VerticalLayout {

    private final SimpleChatbot simpleChatbot; // Inject SimpleChatbot here
    private Div chatArea;
    private TextField messageField;

    @Autowired
    public LunaView(SimpleChatbot simpleChatbot) {
        this.simpleChatbot = simpleChatbot;

        // Set class name for styling
        addClassName("luna-chat-view");

        // Chat area where messages will be displayed
        chatArea = new Div();
        chatArea.addClassName("chat-area");

        // Welcome message from the chatbot
        addChatMessage("Hei! Hvordan kan jeg hjelpe deg i dag? " +
                "\nJeg er fortsatt under utvikling. " +
                "\nAkkurat nå kan jeg svare på noen enkle spørsmål om appen.\n", "bot");

        // Input field for user message
        messageField = new TextField();
        messageField.setPlaceholder("Send en melding til Luna...");
        messageField.addClassName("message-field");

        // Send button
        Button sendButton = new Button("Send", event -> sendMessage());

        // Layout for input field and send button
        HorizontalLayout inputLayout = new HorizontalLayout(messageField, sendButton);
        inputLayout.addClassName("input-layout");

        // Add components to the main layout
        add(chatArea, inputLayout);

        setSizeFull();
    }

    private void sendMessage() {
        String userMessage = messageField.getValue();
        if (!userMessage.isEmpty()) {
            // Add the user's message to the chat
            addChatMessage(userMessage, "user");
            messageField.clear();

            // Get response from SimpleChatbot
            String botResponse = simpleChatbot.getResponse(userMessage);
            addChatMessage(botResponse, "bot");
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

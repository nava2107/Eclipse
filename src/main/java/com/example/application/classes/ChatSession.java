package com.example.application.classes;

import java.util.ArrayList;
import java.util.List;

public class ChatSession {
    private List<Message> messages;

    public ChatSession() {
        this.messages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    // Legg til melding i historikken
    public void addMessage(String role, String content) {
        messages.add(new Message(role, content));
    }

    // Tilbakestill chat-historikken
    public void resetChat() {
        messages.clear();
    }

    // Intern klasse for meldinger
    public static class Message {
        private String role;
        private String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }

        public String getRole() {
            return role;
        }

        public String getContent() {
            return content;
        }
    }
}

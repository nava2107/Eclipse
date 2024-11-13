package com.example.application.classes;

import org.springframework.stereotype.Component;

@Component
public class SimpleChatbot {
    public String getResponse(String userMessage) {
        if (userMessage.contains("hei") || userMessage.contains("hei chatbot")) {
            return "Hei! Hvordan kan jeg hjelpe deg?\n";
        } else if (userMessage.contains("hva er eclipse")) {
            return "Eclipse er en innovativ husholdningsassistent som kan bli brukt av hele familien. \n" +
                    "Appen forenkler administrasjonen og vedlikeholdet av familiens IoT-produkter. \n" +
                    "Eclipse tilbyr også flere hjelpemidler slik at hele familien enkelt kan\n" +
                    "bruke husholdningens IoT-produkter!\n";
        } else if (userMessage.contains("hvem er du")) {
            return "Jeg er Luna, den hjelpsomme chatboten til Eclipse!\n" +
                    "Jeg er her for å hjelpe deg med å enkelt navigere appen og dine IoT-produkter!\n";
        } else if (userMessage.contains("hvorfor er eclipse viktig")) {
            return "Eclipse er viktig for at flest mulig personer skal ha nytte av sine IoT-produkter,\n" +
                    "på en enkel, men trygg måte!\n";
        } else {
            return "Beklager, jeg forstår ikke spørsmålet ditt. " +
                    "\nEclipse-teamet jobber hardt for at jeg skal kunne svare på flere spørsmål.\n" +
                    "Takk for tålmodigheten!\n";
        }
    }
}

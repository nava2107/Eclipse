package com.example.application;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
SpringBoot start
 **/
@SpringBootApplication
@NpmPackage(value = "@fontsource/mukta", version = "4.5.0")
@PWA(name = "My Vaadin PWA", shortName = "Vaadin PWA", offlineResources = {"resources/offline.html"})
@Theme(value = "eclipse")
public class Application implements AppShellConfigurator {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("http://localhost:60401/");
    }
}

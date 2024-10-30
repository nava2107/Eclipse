package com.example.application.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class VerificationController {

    private final UserService userService;

    @Autowired
    public VerificationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/verify")
    public RedirectView verifyUser(@RequestParam("code") String code) {
        boolean isVerified = userService.verifyUserByCode(code);
        if (isVerified) {
            return new RedirectView("/main-view?verification=success");
        } else {
            return new RedirectView("/main-view?verification=failed");
        }
    }
}

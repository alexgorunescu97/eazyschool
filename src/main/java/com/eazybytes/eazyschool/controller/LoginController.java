package com.eazybytes.eazyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = { RequestMethod.GET })
    public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
                                   @RequestParam(value = "logout", required = false) String logout,
                                   @RequestParam(value = "register", required = false) String register,
                                   Model model) {

        String errorMessage = null;

        if (error != null) {
            errorMessage = "Username or Password is incorrect!";
        }

        if (logout != null) {
            errorMessage = "You have been successfully logged out!";
        }

        if (register != null) {
            errorMessage = "You have been registered successfully. Please login with registered credentials!";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "login.html";
    }
}

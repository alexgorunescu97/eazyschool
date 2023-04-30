package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/dashboard")
    public String logoutPage(Model model, Authentication auth, HttpSession session) {
        Person person = personRepository.getByEmail(auth.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", auth.getAuthorities().toString());
        if (person.getEazyClass() != null && person.getEazyClass().getName() != null) {
            model.addAttribute("enrolledClass", person.getEazyClass().getName());
        }

        session.setAttribute("loggedInPerson", person);
        return "dashboard.html";
    }
}

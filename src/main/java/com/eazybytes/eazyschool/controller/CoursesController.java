package com.eazybytes.eazyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoursesController {

    @RequestMapping("/courses")
    public String displayCoursesPage() {
        return "courses.html";
    }
}

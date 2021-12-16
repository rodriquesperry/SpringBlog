package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Sets the purpose of the class to be a controller
public class HelloController {

    @GetMapping("/hello") //use like @WebServlet... where you want the page to be directed to
    @ResponseBody // Annotation for response coming
    public String hello() { // Method that returns the string
        return "Hello from Spring! Happy Holidays!";
    }

}

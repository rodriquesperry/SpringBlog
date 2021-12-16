package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //Sets the purpose of the class to be a controller
public class HelloController {

    @GetMapping("/hello") //use like @WebServlet... where you want the page to be directed to
    @ResponseBody // Annotation for response coming
    public String hello() { // Method that returns the string
        return "Hello from Spring! Happy Holidays!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) { // Use in order to pass in variables
        return "Hello there " + name + "!";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is "+ (number + 1) + "!";
    }
}

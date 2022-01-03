package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String roll() {
        return "roll-dice";
    }

    @PostMapping("/roll-dice")
    public String choose(@RequestParam(name = "die") int n, Model model) {
        model.addAttribute("die", "Your guessed number is " + n);
        return "roll-dice";
    }

}

package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String roll() {

        return "roll-dice";
    }



    @PostMapping("/roll-dice")
    public String choose(@RequestParam(name = "die") int n, Model model) {
        int rando = ((int) (Math.random() * (6 - 1)) + 1);
        model.addAttribute("n", rando);
        model.addAttribute("die", n);
        model.addAttribute("nSent", "The Die is " + rando);
        model.addAttribute("dieSent","Your Guess is " + n);
        return "dice-rolled";
    }

}

package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {


    @GetMapping("/posts")
    public String postIndex() {return "posts/index";}

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable int id) {
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "View the form for creating posts!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return null;
    }
}

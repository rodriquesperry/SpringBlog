package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {


    @GetMapping("/posts")
    public String postIndex(Model model) {
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post("First Array List Post", "Trying to finish up this exercise correctly"),
                new Post("Second Array List Post", "THis is the second post for my arrayList"))
        );
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable int id, Model model) {
        Post post = new Post("post1", "This is the body");
        model.addAttribute("post", post);
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

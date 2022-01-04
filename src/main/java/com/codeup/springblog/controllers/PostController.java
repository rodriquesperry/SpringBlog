package com.codeup.springblog.controllers;

import com.codeup.springblog.daos.PostRepository;
import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postIndex(Model model) {
//        List<Post> posts = new ArrayList<>(Arrays.asList(
//                new Post("First Array List Post", "Trying to finish up this exercise correctly"),
//                new Post("Second Array List Post", "THis is the second post for my arrayList"))
//        );
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
//        Post post = new Post("post1", "This is the body");
        model.addAttribute("post", postDao.findPostById(id));
        return "posts/show";
    }

    @PostMapping("posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @PostMapping("posts/{id}/edit")
    public String edit(@PathVariable long id, @RequestParam(name = "title") Model model) {
        model.addAttribute("post", postDao.findPostById());
        postDao.findPostById(id);
        return "redirect:/post/" + id;
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

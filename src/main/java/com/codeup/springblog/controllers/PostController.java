package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String postIndex(Model model) {
//        List<Post> posts = new ArrayList<>(Arrays.asList(
//                new Post("First Array List Post", "Trying to finish up this exercise correctly"),
//                new Post("Second Array List Post", "THis is the second post for my arrayList"))
//        );
        model.addAttribute("posts", postDao.findAll());
        //boolean value that checks if the database is empty (true or false)
        model.addAttribute("hasPost", postDao.findAll().isEmpty());
        return "posts/index";
    }

    @GetMapping("posts/{id}")
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

    @GetMapping("posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
//        model.addAttribute("post", postDao.findPostById(id));
//        Post post = postDao.findPostById(id);
//        model.addAttribute("postToEdit", post);
        model.addAttribute("editPost", postDao.findPostById(id));
        return "posts/edit";
    }

    @PostMapping("posts/{id}/edit")
    public String edit(@PathVariable long id, @ModelAttribute Post editPost) {
//                       @PathVariable long id,
//                       @RequestParam(name = "title") String title,
//                       @RequestParam(name="body") String body, Model model) {
//        Post post = postDao.findPostById(id);
//        post.setTitle(title);
//        post.setBody(body);
//        model.addAttribute("post", postDao.save(post));
        editPost.setUser(userDao.findUserById(1));
        postDao.save(editPost);
        return "redirect:/posts/" + id;
    }

    @GetMapping("/posts/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(loggedInUser);

        String emailSubject = post.getUser().getUsername() + ", Your post titled: " + post.getTitle() + " has been created";
        String emailBody = "Congrats!-your latest blog post is up and ready to view on your blogging website. It read: " + post.getBody();
        emailService.prepareAndSend(post, emailSubject, emailBody);
        postDao.save(post);


        return "redirect:/posts";
    }
}

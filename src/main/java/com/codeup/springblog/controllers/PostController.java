package com.codeup.springblog.controllers;

import com.codeup.springblog.daos.PostRepository;
import com.codeup.springblog.daos.UserRepository;
import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;}

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
        model.addAttribute("post", postDao.findPostById(id));
        Post post = postDao.findPostById(id);
        model.addAttribute("postToEdit", post);
        System.out.println("post.getTitle() = " + post.getTitle());
        System.out.println("post.getBody() = " + post.getBody());
        return "posts/edit";
    }

    @PostMapping("posts/{id}/edit")
    public String edit(@PathVariable long id,
                       @RequestParam(name = "title") String title,
                       @RequestParam(name="body") String body, Model model) {
        Post post = postDao.findPostById(id);
        post.setTitle(title);
        post.setBody(body);

        model.addAttribute("post", postDao.save(post));

        return "redirect:/posts/" + id;
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

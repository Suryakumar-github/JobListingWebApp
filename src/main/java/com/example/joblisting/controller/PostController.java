package com.example.joblisting.controller;

import com.example.joblisting.model.Post;

import com.example.joblisting.repository.SearchRepository;
import com.example.joblisting.repository.postRepo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController
{
    @Autowired
    postRepo repo;

   @Autowired
    SearchRepository searchrepo;


    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPost()
    {
        return repo.findAll();
    }
    @GetMapping("/posts/{text}")
    @CrossOrigin
     public List<Post> search( String text)
    {
        return searchrepo.findByText(text);
    }

    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }
}

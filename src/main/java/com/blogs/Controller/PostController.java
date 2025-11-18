package com.blogs.Controller;

import com.blogs.DTOs.PostRequestDto;
import com.blogs.DTOs.PostResponseDto;
import com.blogs.Service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "https://blogbyyatharth.netlify.app/")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping("/createPost")
    public ResponseEntity<PostResponseDto> createPost(
            @RequestBody PostRequestDto postDto,
            Principal principal
    ) {
        String username = principal.getName();
        PostResponseDto response = service.createPost(postDto, username);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/viewAllPost")
    public ResponseEntity<List<PostResponseDto>> viewPosts() {
        return ResponseEntity.ok(service.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> viewPost(@PathVariable Integer id){
        return ResponseEntity.ok(service.getPost(id));
    }
}

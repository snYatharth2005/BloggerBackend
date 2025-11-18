package com.blogs.Service;

import com.blogs.DTOs.PostDto;
import com.blogs.DTOs.PostMapper;
import com.blogs.DTOs.PostRequestDto;
import com.blogs.DTOs.PostResponseDto;
import com.blogs.Model.Post;
import com.blogs.Model.User;
import com.blogs.Repository.PostRepository;
import com.blogs.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public PostResponseDto createPost(PostRequestDto dto, String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setUser(user);

        post = postRepository.save(post);

        return PostMapper.toDto(post);
    }

    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostMapper::toDto)
                .toList();
    }

    public PostResponseDto getPost(Integer id) {
        return postRepository.findById(id)
                .map(PostMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Post Not Found with id " + id));
    }
}

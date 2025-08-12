package com.example.micro.controller;

import com.example.micro.model.Post;
import com.example.micro.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*")
public class PostController {
    private final PostRepository repo;

    public PostController(PostRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Post> all() {
        return repo.findAllByOrderByTimestampDesc();
    }

    @PostMapping
    public Post create(@RequestBody Post p) {
        if (p.getTimestamp() == null) p.setTimestamp(java.time.LocalDateTime.now());
        return repo.save(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Post> op = repo.findById(id);
        if (op.isEmpty()) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

package com.blogs.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

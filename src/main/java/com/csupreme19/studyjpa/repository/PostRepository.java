package com.csupreme19.studyjpa.repository;

import com.csupreme19.studyjpa.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

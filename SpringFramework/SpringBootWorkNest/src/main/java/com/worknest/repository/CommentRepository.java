package com.worknest.repository;

import com.worknest.model.Comment;
import com.worknest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    // Spring Data JPA will create the query automatically
    List<Comment> findByTaskOrderByCreatedAtDesc(Task task);
}

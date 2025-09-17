// com/worknest/service/CommentService.java
package com.worknest.service;

import com.worknest.model.Comment;
import com.worknest.model.Task;
import com.worknest.model.User;
import com.worknest.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @Transactional
public class CommentService {
    private final CommentRepository repo;
    public CommentService(CommentRepository repo){ this.repo = repo; }

    public void add(Task task, User user, String content){
        Comment c = new Comment();
        c.setTask(task); c.setUser(user); c.setContent(content);
        repo.save(c);
    }
    public List<Comment> forTask(Task task){
    	return repo.findByTaskOrderByCreatedAtDesc(task); 
    }
}

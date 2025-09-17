package com.worknest.service;

import com.worknest.dao.CommentDao;
import com.worknest.model.Comment;
import com.worknest.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public void addComment(Comment comment) {
        commentDao.save(comment);
    }

    public List<Comment> getCommentsByTask(Task task) {
        return commentDao.findByTask(task);
    }
}

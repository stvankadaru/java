package com.worknest.dao;

import com.worknest.model.Comment;
import com.worknest.model.Task;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    // Save new comment
    public void save(Comment comment) {
        sessionFactory.getCurrentSession().persist(comment);
    }

    // Update existing comment
    public void update(Comment comment) {
        sessionFactory.getCurrentSession().merge(comment);
    }

    // Delete comment
    public void delete(Comment comment) {
        sessionFactory.getCurrentSession().remove(comment);
    }

    // Find comment by ID
    public Comment findById(Long id) {
        return sessionFactory.getCurrentSession().get(Comment.class, id);
    }

    // Find all comments for a given task
    public List<Comment> findByTask(Task task) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Comment where task = :task", Comment.class)
                .setParameter("task", task)
                .list();
    }

    // Find all comments
    public List<Comment> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Comment", Comment.class)
                .list();
    }
}

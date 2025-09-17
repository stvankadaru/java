package com.worknest.dao;

import com.worknest.model.Task;
import com.worknest.model.User;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Task task) {
        sessionFactory.getCurrentSession().persist(task);
    }

    public void update(Task task) {
        sessionFactory.getCurrentSession().merge(task);
    }
    public List<Task> findByStatus(String status) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Task where status = :status", Task.class)
                .setParameter("status", status)
                .list();
    }


    public void delete(Task task) {
        sessionFactory.getCurrentSession().remove(task);
    }

    public Task findById(Long id) {
        return sessionFactory.getCurrentSession().get(Task.class, id);
    }

    public List<Task> findByUser(User user) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Task where assignedUser = :user", Task.class)
                .setParameter("user", user)
                .list();
    }

    public List<Task> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Task", Task.class)
                .list();
    }
}

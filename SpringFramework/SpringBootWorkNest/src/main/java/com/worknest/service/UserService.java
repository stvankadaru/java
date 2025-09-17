// com/worknest/service/UserService.java
package com.worknest.service;

import com.worknest.model.User;
import com.worknest.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @Transactional
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){ this.userRepository = userRepository; }

    public void register(User u){ userRepository.save(u); }

    public User login(String email, String password){
        User u = userRepository.findByEmail(email);
        return (u != null && u.getPassword().equals(password)) ? u : null;
    }

    public List<User> all(){ return userRepository.findAll(); }
    public User byId(int id){ return userRepository.findById(id).orElse(null); }
    public void delete(int id){ userRepository.deleteById(id); }
}

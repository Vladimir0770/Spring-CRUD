package com.love2code.employeedirectory.service;

import com.love2code.employeedirectory.entity.User;
import com.love2code.employeedirectory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Long id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return userRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

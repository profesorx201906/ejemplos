package com.backend.banca.usersV2.Service;


import com.backend.banca.usersV2.Entity.User;
import com.backend.banca.usersV2.Repository.UserRepositoryV2;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceV2 {
    private UserRepositoryV2 userRepository = new UserRepositoryV2();
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(String id) {
        return userRepository.findById(id);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(String id, User user) {
        user.setId(id);
        return userRepository.update(user);
    }

    public boolean deleteUser(String id) {
        return userRepository.delete(id);
    }
}

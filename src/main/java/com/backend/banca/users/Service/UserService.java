package com.backend.banca.users.Service;


import com.backend.banca.users.Entity.User;
import com.backend.banca.users.Repository.UserRepository;
import com.github.javafaker.Faker;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository = new UserRepository();
    private Faker faker = new Faker();
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(String id) {
        return userRepository.findById(id);
    }
    public User createUser() {
        User user = new User();
        user.setId(faker.random().hex());
        user.setName(faker.name().firstName() +" "+faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
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

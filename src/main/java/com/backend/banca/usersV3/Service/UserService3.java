package com.backend.banca.usersV3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.banca.usersV3.Entity.User3;
import com.backend.banca.usersV3.Repository.UserRepository3;

@Service
public class UserService3 {
    @Autowired
    UserRepository3 userRepository3;
    public User3 save(User3 user) {
        return userRepository3.save(user);
    }
    public List<User3> findAll() {
        return (List<User3>) userRepository3.findAll();
    }
    public User3 getUserById(String id) {
        return userRepository3.findById(id).get();
    }
    public Boolean deleteById(String id) {
        try {
            userRepository3.deleteById(id);
            return true;
        } catch (Exception e) {

            return false;
        }
    }
    public User3 findByName(String valor) {
        return userRepository3.findByName(valor);
    }
    public List<User3> findByNombrePartialManual(String nombre) {
        return (List<User3>) userRepository3.findByNombrePartialManual(nombre);
    }
}

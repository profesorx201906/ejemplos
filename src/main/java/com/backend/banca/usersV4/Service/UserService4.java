package com.backend.banca.usersV4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.banca.usersV4.Entity.User4;
import com.backend.banca.usersV4.Repository.UserRepository4;

@Service
public class UserService4 {
    @Autowired
    UserRepository4 userRepository4;
    public User4 save(User4 user) {
        return userRepository4.save(user);
    }
    public List<User4> findAll() {
        return (List<User4>) userRepository4.findAll();
    }
    public User4 getUserById(String id) {
        return userRepository4.findById(id).get();
    }
    public Boolean deleteById(String id) {
        try {
            userRepository4.deleteById(id);
            return true;
        } catch (Exception e) {

            return false;
        }
    }
    public User4 findByName(String valor) {
        return userRepository4.findByName(valor);
    }
    public List<User4> findByNombrePartialManual(String nombre) {
        return (List<User4>) userRepository4.findByNombrePartialManual(nombre);
    }
}

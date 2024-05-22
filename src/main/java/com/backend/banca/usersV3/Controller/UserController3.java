package com.backend.banca.usersV3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.banca.usersV3.Entity.User3;
import com.backend.banca.usersV3.Service.UserService3;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("API/v3/users")
@CrossOrigin("*")
public class UserController3 {
    @Autowired
    private UserService3 userService;
    @GetMapping
    public ResponseEntity<List<User3>> getAllUsers() {
        List<User3> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User3> getUserById(@PathVariable String id) {
        User3 user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<User3> createUser(@Valid @RequestBody User3 user) {
        User3 createdUser = userService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User3> updateUser(@PathVariable String id, @RequestBody User3 user) {
        user.setId(id);
        User3 updatedUser = userService.save(user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        boolean deleted = userService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/nombre/{valor}")
    public ResponseEntity<Object> findByName(@PathVariable("valor") String valor) {
        if (userService.findByName(valor) == null) {
            return new ResponseEntity<>("{\"status\":404,\"message\":\"Usuario encontrado\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.findByName(valor), HttpStatus.OK);
    }

    @GetMapping("/nombreParcial/{valor}")
    public ResponseEntity<Object> findByNombrePartialManual(@PathVariable("valor") String valor) {
        if (userService.findByNombrePartialManual(valor) == null) {
            return new ResponseEntity<>("{\"status\":404,\"message\":\"Usuario encontrado\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.findByNombrePartialManual(valor), HttpStatus.OK);
    }
}

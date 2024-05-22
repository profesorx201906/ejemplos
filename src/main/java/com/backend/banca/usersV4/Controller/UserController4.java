package com.backend.banca.usersV4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.banca.usersV4.Entity.User4;
import com.backend.banca.usersV4.Service.UserService4;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("API/v4/users")
@CrossOrigin("*")
public class UserController4 {
    @Autowired
    private UserService4 userService;
    @GetMapping
    public ResponseEntity<List<User4>> getAllUsers() {
        List<User4> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User4> getUserById(@PathVariable String id) {
        User4 user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<User4> createUser(@Valid @RequestBody User4 user) {
        User4 createdUser = userService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User4> updateUser(@PathVariable String id, @RequestBody User4 user) {
        user.setId(id);
        User4 updatedUser = userService.save(user);
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

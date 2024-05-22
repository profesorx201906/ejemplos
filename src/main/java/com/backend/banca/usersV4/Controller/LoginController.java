package com.backend.banca.usersV4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.banca.usersV4.Entity.Cliente;
import com.backend.banca.usersV4.Security.Hash;
import com.backend.banca.usersV4.Service.ClienteService;
import com.backend.banca.usersV4.Service.RolService;

@RestController
@RequestMapping("API/v4")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    RolService rolService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestHeader String user, @RequestHeader String pwd) {
        Cliente cliente = clienteService.findByUserName(user);
        if (cliente == null) {
            return new ResponseEntity<>("El usario no existe", HttpStatus.NOT_FOUND);
        } else {
            if (cliente.getPassword().equals(Hash.sha1(pwd))) {
                return new ResponseEntity<>(cliente, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Error de credenciales", HttpStatus.UNAUTHORIZED);
            }
        }
    }
}


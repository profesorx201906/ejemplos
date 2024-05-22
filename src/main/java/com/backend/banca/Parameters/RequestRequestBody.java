package com.backend.banca.Parameters;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.banca.Response.Entity.Persona;

@RestController
@RequestMapping("/API/v1/requestbody")
@CrossOrigin(origins = "*")
public class RequestRequestBody {
    @GetMapping("/recibir")
    public String datos(@RequestBody String user) {
        return user;
    }

    @GetMapping("/recibirPersona")
    public Integer createUser(@RequestBody Persona user) {
        return user.getEdad();
    }


}


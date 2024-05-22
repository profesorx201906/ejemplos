package com.backend.banca.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.banca.Response.Entity.Persona;
@RestController
@RequestMapping("API/v1/response")
@CrossOrigin(origins = "*")
public class Respuesta {

    @GetMapping("/simple")
    public ResponseEntity<String> testSimple(){
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    @GetMapping("/complex")
    public ResponseEntity<Persona> testComplex(){
        Persona persona = new Persona("919522", "Pedro", "Perez", 25);
        return new ResponseEntity<Persona>(persona, HttpStatus.CREATED);
    }
}


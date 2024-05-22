package com.backend.banca.Parameters;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("API/v1/headers")
@CrossOrigin(origins = "*")
public class RequestHeaders {
 @GetMapping("/requerido")
    public String getRequest(@RequestHeader(name = "nombre") String nombre) {

        return ("Dato enviado en variable nombre : " + nombre );
    }

}

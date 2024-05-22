package com.backend.banca.Parameters;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API/v1/pathvariable")
@CrossOrigin(origins = "*")
public class RequestPathVariable {

    @GetMapping("/requerido/{nombre}")
    public String getRequestPathVariable(@PathVariable(name = "nombre") String nombreReq) {

        return ("Dato enviado en variable nombre : " + nombreReq + " [ REQUERIDO ]");
    }

    @GetMapping({"/norequerido/","/norequerido/{nombre}"})
    public String getRequestPathVariableNotRequired(@PathVariable(name = "nombre", required = false) String nombreReq) {

        return ("Dato enviado en variable nombre : " + nombreReq + " [ NO REQUERIDO ]");
    }

}




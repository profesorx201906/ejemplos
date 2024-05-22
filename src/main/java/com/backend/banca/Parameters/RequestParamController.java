package com.backend.banca.Parameters;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("API/v1/request")
@CrossOrigin(origins = "*")
public class RequestParamController {
    @GetMapping("/requerido")
    public String getRequest(@RequestParam(name = "nombre") String nombreReq) {

        return ("Dato enviado en variable nombre : " + nombreReq + " [ REQUERIDO ]");
    }

    @GetMapping("/norequerido")
    public String getRequestNotRequired(@RequestParam(name = "nombre", required = false) String nombreReq) {

        return ("Dato enviado en variable nombre : " + nombreReq + " [ NO REQUERIDO ]");
    }

    @GetMapping("/norequeridodefecto")
    public String getRequestNotRequiredDefault(
            @RequestParam(name = "nombre", required = false, defaultValue = "Falta dato") String nombreReq) {

        return ("Dato enviado en variable nombre : " + nombreReq + " [ NO REQUERIDO - POR DEFECTO ]");
    }
}
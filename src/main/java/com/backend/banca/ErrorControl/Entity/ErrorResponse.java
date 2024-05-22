package com.backend.banca.ErrorControl.Entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
    private Date timestamp;
    List<Error> errors;
    ErrorResponse (String message){
        this.message=message;
    }
    public void setError(List<Error> errores) {
        errors=errores;
    }
}

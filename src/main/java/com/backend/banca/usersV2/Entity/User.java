package com.backend.banca.usersV2.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    @NotNull(message = "El campo name no puede ser")
    private String name;
    @Email(message = "no es correcto")
    private String email;
    @Min(18)
    @Max(40)
    private int edad;
}
package com.security.crud_v2.dto.Entidad_Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {


    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 6, message = "El nombre debe tener al menos 3 caracteres")
    private String nombre;

    @NotBlank(message = "La direccion no puede estar vacía")
    @Size(min = 10, message = "La direccion debe tener al menos 10 caracteres")
    private String direccion;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El correo electrónico no es válido.")
    private String email;


}

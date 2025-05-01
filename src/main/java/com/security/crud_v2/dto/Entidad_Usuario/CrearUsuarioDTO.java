package com.security.crud_v2.dto.Entidad_Usuario;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearUsuarioDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 4, message = "El nombre debe tener al menos 4 caracteres")
    private String nombre;

    @NotBlank(message = "La direccion no puede estar vacía")
    @Size(min = 10, message = "La direccion debe tener al menos 10 caracteres")
    private String direccion;

    @NotNull(message = "La cedula no puede estar vacía")
    @Min(value = 100000, message = "La cédula debe tener al menos 6 dígitos")
    private Long cedula;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El correo electrónico no es válido.")
    private String email;

    @NotBlank(message = "La clave no puede estar vacía")
    private String clave;

}

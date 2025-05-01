package com.security.crud_v2.dto.Entidad_Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualizarUsuarioDTO {

    @NotBlank(message = "La direccion no puede estar vacía")
    @Size(min = 10, message = "La direccion debe tener al menos 10 caracteres")
    private String direccion;


    @NotBlank(message = "La clave no puede estar vacía")
    private String clave;

}

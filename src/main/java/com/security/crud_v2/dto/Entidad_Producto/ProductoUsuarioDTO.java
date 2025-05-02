package com.security.crud_v2.dto.Entidad_Producto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoUsuarioDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 4, message = "El nombre debe tener al menos 4 caracteres")
    private String nombre;

    @NotBlank(message = "La descripcion no puede estar vacía")
    @Size(min = 10, message = "La descripcion debe tener al menos 10 caracteres")
    private String descripcion;

    @NotNull(message = "El precio no puede ser 0")
    @Min(value = 1, message = "El precio debe tener al menos 6 dígitos")
    private Double precio;

    @NotNull(message = "La cantidad no puede ser 0")
    @Min(value = 1, message = "El precio debe tener al menos 6 dígitos")
    private Double cantidad;

}

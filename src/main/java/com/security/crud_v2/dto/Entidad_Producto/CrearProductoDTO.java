package com.security.crud_v2.dto.Entidad_Producto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearProductoDTO {

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

    @NotBlank(message = "El serial no puede estar vacío")
    @Size(min = 4, message = "El serial debe tener al menos 4 caracteres")
    private String serial;


}

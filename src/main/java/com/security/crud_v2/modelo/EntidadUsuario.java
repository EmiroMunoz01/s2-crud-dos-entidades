package com.security.crud_v2.modelo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entidad_usuario")
public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = false)
    private String nombre;

    @Column(name = "direccion", nullable = false, unique = false)
    private String direccion;

    @Column(name = "cedula", nullable = false, unique = true)
    private Long cedula;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "clave", nullable = false)
    private String clave;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Role role;

}

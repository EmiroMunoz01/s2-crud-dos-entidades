package com.security.crud_v2.repositorio;

import com.security.crud_v2.modelo.EntidadProducto;
import com.security.crud_v2.modelo.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepositorio extends JpaRepository<EntidadProducto, Long> {

    Optional<EntidadProducto> findEntidadProductoBySerial(String serial);

    void deleteEntidadProductoBySerial(String serial);
}

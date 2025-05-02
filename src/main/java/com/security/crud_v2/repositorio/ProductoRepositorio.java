package com.security.crud_v2.repositorio;

import com.security.crud_v2.modelo.EntidadProducto;
import com.security.crud_v2.modelo.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepositorio extends JpaRepository<EntidadProducto, Long> {

    // 1. Búsqueda por serial (retorna Optional)
    Optional<EntidadProducto> findEntidadProductoBySerial(String serial);

    // 2. Eliminación por serial
    void deleteEntidadProductoBySerial(String serial);

    //  3. Verificación de existencia
    boolean existsBySerial(String serial);
}

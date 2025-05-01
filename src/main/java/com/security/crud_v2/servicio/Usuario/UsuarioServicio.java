package com.security.crud_v2.servicio.Usuario;



import com.security.crud_v2.dto.Entidad_Usuario.ActualizarUsuarioDTO;
import com.security.crud_v2.dto.Entidad_Usuario.CrearUsuarioDTO;
import com.security.crud_v2.dto.Entidad_Usuario.UsuarioDTO;
import com.security.crud_v2.modelo.EntidadUsuario;
import com.security.crud_v2.modelo.Role;
import com.security.crud_v2.repositorio.UsuarioRepositorio;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Service
public class UsuarioServicio implements IUsuario {

    private static final Logger log = LoggerFactory.getLogger(UsuarioServicio.class);
    private final UsuarioRepositorio repositorio;

    public UsuarioServicio(UsuarioRepositorio repositorio) {

        this.repositorio = repositorio;
    }

    private UsuarioDTO convertirAUsuarioDTO(EntidadUsuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNombre(usuario.getNombre());
        dto.setDireccion(usuario.getDireccion());
        dto.setEmail(usuario.getEmail());
        return dto;
    }

    //Metodo para listar todos los usuarios
    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return repositorio.findAll().stream()
                .map(this::convertirAUsuarioDTO)
                .toList();
    }

    //Metodo para eliminar un usuario mediante email
    @Transactional
    @Override
    public String eliminarUsuarioPorEmail(String email) {
        // Validación básica del email
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser nulo o vacío");
        }

        // Verificar si el usuario existe antes de eliminarlo (opcional)
        if (!repositorio.existsByEmail(email)) {
            throw new EntityNotFoundException("No se encontró un usuario con el email: " + email);
        }

        try {
            repositorio.deleteByEmail(email);
            // Opcional: Log de éxito
            log.info("Usuario con email {} eliminado correctamente", email);

        } catch (Exception ex) {
            // Log del error y relanzamiento controlado
            log.error("Error al eliminar usuario con email: " + email, ex);
            throw new RuntimeException("Error al eliminar el usuario", ex);
        }

        return "Usuario Eliminado con exito";

    }

    //Metodo para crear un usuario
    @Override
    public CrearUsuarioDTO crearUsuario(CrearUsuarioDTO usuarioDTO) {

        EntidadUsuario nuevoUsuario = new EntidadUsuario();

        nuevoUsuario.setNombre(usuarioDTO.getNombre());
        nuevoUsuario.setCedula(usuarioDTO.getCedula());
        nuevoUsuario.setDireccion(usuarioDTO.getDireccion());
        nuevoUsuario.setClave(usuarioDTO.getClave());
        nuevoUsuario.setEmail(usuarioDTO.getEmail());
        nuevoUsuario.setRole(Role.ROLE_USER);

        repositorio.save(nuevoUsuario);

        return usuarioDTO;
    }

    //Metodo para actualizar un usuario
    @Override
    public ActualizarUsuarioDTO actualizarUsuarioPorEmail(String email, ActualizarUsuarioDTO usuario) {
        // Validar email
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser nulo o vacío");
        }

        // Buscar usuario existente
        EntidadUsuario buscarEntidad = repositorio.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con email: " + email));

        // Validar DTO de entrada
        if (usuario == null) {
            throw new IllegalArgumentException("Los datos de actualización no pueden ser nulos");
        }

        // Actualizar campos (solo si no son nulos en el DTO)
        if (usuario.getClave() != null) {
            buscarEntidad.setClave(usuario.getClave());
        }


        if (usuario.getDireccion() != null) {
            buscarEntidad.setDireccion(usuario.getDireccion());
        }

        // Guardar cambios
        EntidadUsuario entidadActualizada = repositorio.save(buscarEntidad);

        // Convertir entidad actualizada a DTO
        ActualizarUsuarioDTO usuarioModificado = new ActualizarUsuarioDTO();
        usuarioModificado.setClave(entidadActualizada.getClave());
        usuarioModificado.setDireccion(entidadActualizada.getDireccion());

        return usuarioModificado;
    }

    //Metodo para eliminar un usuario
    @Override
    public UsuarioDTO buscarUsuarioPorEmail(String email) {

        EntidadUsuario buscarUsuario = repositorio.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con email: " + email));

        UsuarioDTO usuarioEncontrado = new UsuarioDTO();
        usuarioEncontrado.setEmail(buscarUsuario.getEmail());
        usuarioEncontrado.setDireccion(buscarUsuario.getDireccion());
        usuarioEncontrado.setNombre(buscarUsuario.getNombre());

        return usuarioEncontrado;

    }
}

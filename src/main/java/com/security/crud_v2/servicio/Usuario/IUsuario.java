package com.security.crud_v2.servicio.Usuario;





import com.security.crud_v2.dto.Entidad_Usuario.ActualizarUsuarioDTO;
import com.security.crud_v2.dto.Entidad_Usuario.CrearUsuarioDTO;
import com.security.crud_v2.dto.Entidad_Usuario.UsuarioDTO;

import java.util.List;

public interface IUsuario {

    public List<UsuarioDTO> listarUsuarios();

    public String eliminarUsuarioPorEmail(String email);

    public CrearUsuarioDTO crearUsuario(CrearUsuarioDTO usuario);

    public ActualizarUsuarioDTO actualizarUsuarioPorEmail(String email, ActualizarUsuarioDTO usuario);

    public UsuarioDTO buscarUsuarioPorEmail(String email);



}

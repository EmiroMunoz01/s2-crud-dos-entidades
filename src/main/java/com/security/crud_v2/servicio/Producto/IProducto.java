package com.security.crud_v2.servicio.Producto;

import com.security.crud_v2.dto.Entidad_Producto.ActualizarProductoDTO;
import com.security.crud_v2.dto.Entidad_Producto.CrearProductoDTO;
import com.security.crud_v2.dto.Entidad_Producto.ProductoAdministradorDTO;
import com.security.crud_v2.dto.Entidad_Producto.ProductoUsuarioDTO;

import java.util.List;

public interface IProducto {

    public List<ProductoUsuarioDTO> mostrarProductosUsuario();

    public List<ProductoAdministradorDTO> mostrarProductosAdmin();

    public CrearProductoDTO crearProductoAdmin(CrearProductoDTO crearProductoDTO);

    public ActualizarProductoDTO actualizarProducto(String serial, ActualizarProductoDTO actualizarProductoDTO);

    public ProductoAdministradorDTO buscarProductoPorSerialAdmin(String serial);

    public ProductoUsuarioDTO buscarProductoPorSerialUsuario(String serial);

    public void eliminarProducto(String serial);

}

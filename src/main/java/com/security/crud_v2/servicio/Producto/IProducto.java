package com.security.crud_v2.servicio.Producto;

import com.security.crud_v2.dto.Entidad_Producto.ActualizarProductoDTO;
import com.security.crud_v2.dto.Entidad_Producto.CrearProductoDTO;
import com.security.crud_v2.dto.Entidad_Producto.ProductoAdminDTO;
import com.security.crud_v2.dto.Entidad_Producto.ProductoUserDTO;

import java.util.List;

public interface IProducto {

    public List<ProductoUserDTO> mostrarProductosUser();

    public List<ProductoAdminDTO> mostrarProductosAdmin();

    public CrearProductoDTO crearProductoAdmin(CrearProductoDTO crearProductoDTO);

    public ActualizarProductoDTO actualizarProducto(String serial, ActualizarProductoDTO actualizarProductoDTO);

    public ProductoAdminDTO buscarProductoPorSerialAdmin(String serial);

    public ProductoUserDTO buscarProductoPorSerialUsuario(String serial);

    public void eliminarProducto(String serial);

}

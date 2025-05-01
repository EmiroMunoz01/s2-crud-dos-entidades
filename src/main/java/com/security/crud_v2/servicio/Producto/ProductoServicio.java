package com.security.crud_v2.servicio.Producto;


import com.security.crud_v2.dto.Entidad_Producto.ActualizarProductoDTO;
import com.security.crud_v2.dto.Entidad_Producto.CrearProductoDTO;
import com.security.crud_v2.dto.Entidad_Producto.ProductoAdminDTO;
import com.security.crud_v2.dto.Entidad_Producto.ProductoUserDTO;
import com.security.crud_v2.repositorio.ProductoRepositorio;
import com.security.crud_v2.repositorio.UsuarioRepositorio;
import com.security.crud_v2.servicio.Usuario.UsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio implements IProducto {

    //esta linea de codigo sera la encargada de ayudarnos a manipular las
    // sentencias de error que se generan en nuestra aplicacion

    private static final Logger log = LoggerFactory.getLogger(ProductoServicio.class);


    //aqui estamos inyectando el repositorio y los metodos del mismo sobre el cual trabajaremos
    private final ProductoRepositorio repositorio;

    public ProductoServicio(ProductoRepositorio repositorio) {
        this.repositorio = repositorio;
    }


    @Override
    public List<ProductoUserDTO> mostrarProductosUser() {
        return List.of();
    }

    @Override
    public List<ProductoAdminDTO> mostrarProductosAdmin() {
        return List.of();
    }

    @Override
    public CrearProductoDTO crearProductoAdmin(CrearProductoDTO crearProductoDTO) {
        return null;
    }

    @Override
    public ActualizarProductoDTO actualizarProducto(String serial, ActualizarProductoDTO actualizarProductoDTO) {
        return null;
    }

    @Override
    public ProductoAdminDTO buscarProductoPorSerialAdmin(String serial) {
        return null;
    }

    @Override
    public ProductoUserDTO buscarProductoPorSerialUsuario(String serial) {
        return null;
    }

    @Override
    public void eliminarProducto(String serial) {

    }
}

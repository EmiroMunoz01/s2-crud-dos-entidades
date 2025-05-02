package com.security.crud_v2.servicio.Producto;


import com.security.crud_v2.dto.Entidad_Producto.ActualizarProductoDTO;
import com.security.crud_v2.dto.Entidad_Producto.CrearProductoDTO;

import com.security.crud_v2.dto.Entidad_Producto.ProductoAdministradorDTO;

import com.security.crud_v2.dto.Entidad_Producto.ProductoUsuarioDTO;
import com.security.crud_v2.dto.Entidad_Usuario.UsuarioDTO;
import com.security.crud_v2.modelo.EntidadProducto;
import com.security.crud_v2.repositorio.ProductoRepositorio;
import com.security.crud_v2.repositorio.UsuarioRepositorio;
import com.security.crud_v2.servicio.Usuario.UsuarioServicio;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.ServletConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductoServicio implements IProducto {

    //esta linea de codigo sera la encargada de ayudarnos a manipular las
    // sentencias de error que se generan en nuestra aplicacion

    private static final Logger log = LoggerFactory.getLogger(ProductoServicio.class);


    //aqui estamos inyectando el repositorio y los metodos del mismo sobre el cual trabajaremos
    private final ProductoRepositorio repositorio;

    public ProductoServicio(ProductoRepositorio repositorio, ServletConfig servletConfig) {
        this.repositorio = repositorio;

    }


    private ProductoUsuarioDTO convertirProductoUsuarioDTO(EntidadProducto entidadProducto) {

        ProductoUsuarioDTO productoDTOUsuario = new ProductoUsuarioDTO();
        productoDTOUsuario.setNombre(entidadProducto.getNombre());
        productoDTOUsuario.setDescripcion(entidadProducto.getNombre());
        productoDTOUsuario.setCantidad(entidadProducto.getCantidad());
        productoDTOUsuario.setPrecio(entidadProducto.getPrecio());

        return productoDTOUsuario;
    }

    private ProductoAdministradorDTO convertirProductoAdministradorDTO(EntidadProducto entidadProducto) {

        ProductoAdministradorDTO productoDTOAdministrador = new ProductoAdministradorDTO();
        productoDTOAdministrador.setNombre(entidadProducto.getNombre());
        productoDTOAdministrador.setDescripcion(entidadProducto.getNombre());
        productoDTOAdministrador.setCantidad(entidadProducto.getCantidad());
        productoDTOAdministrador.setPrecio(entidadProducto.getPrecio());
        productoDTOAdministrador.setCantidad(entidadProducto.getCantidad());
        productoDTOAdministrador.setSerial(entidadProducto.getSerial());
        productoDTOAdministrador.setFechaCreacion(entidadProducto.getFechaCreacion());

        return productoDTOAdministrador;
    }


    @Override
    public List<ProductoUsuarioDTO> mostrarProductosUsuario() {
        return repositorio.findAll().stream().map(this::convertirProductoUsuarioDTO).toList();
    }


    @Override
    public List<ProductoAdministradorDTO> mostrarProductosAdmin() {
        return repositorio.findAll().stream().map(this::convertirProductoAdministradorDTO).toList();
    }

    @Override
    public CrearProductoDTO crearProductoAdmin(CrearProductoDTO crearProductoDTO) {


        repositorio.findEntidadProductoBySerial(crearProductoDTO.getSerial())
                .ifPresent(p -> {
                    throw new EntityNotFoundException("El producto con serial: " + crearProductoDTO.getSerial() + " ya existe.");
                });


        EntidadProducto productoNuevo = new EntidadProducto();
        productoNuevo.setNombre(crearProductoDTO.getNombre());
        productoNuevo.setDescripcion(crearProductoDTO.getDescripcion());
        productoNuevo.setPrecio(crearProductoDTO.getPrecio());
        productoNuevo.setCantidad(crearProductoDTO.getCantidad());
        productoNuevo.setFechaCreacion(LocalDateTime.now());
        productoNuevo.setSerial(crearProductoDTO.getSerial());
        repositorio.save(productoNuevo);

        return crearProductoDTO;
    }








    @Override
    public ActualizarProductoDTO actualizarProducto(String serial, ActualizarProductoDTO actualizarProductoDTO) {


        //verificaremos si el serial se esta modificando
        if (!serial.equals(actualizarProductoDTO.getSerial())) {
            //de ser asi revisaremos si este serial ya existe en la base de datos
            if (repositorio.existsBySerial(actualizarProductoDTO.getSerial())) {
                //si efectivamente existe el serial, lo que arrojaremos es un error que indique la existencia del mismo.
                throw new IllegalStateException("Serial ya existe");
            }
        }



        EntidadProducto buscarProducto = repositorio.findEntidadProductoBySerial(serial).orElseThrow(()-> new EntityNotFoundException(String.format("No se encontró producto con el serial: %s", serial)));

        buscarProducto.setNombre(actualizarProductoDTO.getNombre());
        buscarProducto.setDescripcion(actualizarProductoDTO.getDescripcion());
        buscarProducto.setPrecio(actualizarProductoDTO.getPrecio());
        buscarProducto.setCantidad(actualizarProductoDTO.getCantidad());
        buscarProducto.setSerial(actualizarProductoDTO.getSerial());

        repositorio.save(buscarProducto);


        return actualizarProductoDTO;
    }

















    @Override
    public ProductoAdministradorDTO buscarProductoPorSerialAdmin(String serial) {
        return null;
    }

    @Override
    public ProductoUsuarioDTO buscarProductoPorSerialUsuario(String serial) {
        return null;
    }

    @Override
    public void eliminarProducto(String serial) {

    }
}

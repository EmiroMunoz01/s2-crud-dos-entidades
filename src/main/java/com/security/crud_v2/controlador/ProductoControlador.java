package com.security.crud_v2.controlador;


import com.security.crud_v2.dto.Entidad_Producto.ActualizarProductoDTO;
import com.security.crud_v2.dto.Entidad_Producto.CrearProductoDTO;

import com.security.crud_v2.dto.Entidad_Producto.ProductoAdministradorDTO;
import com.security.crud_v2.dto.Entidad_Producto.ProductoUsuarioDTO;
import com.security.crud_v2.servicio.Producto.ProductoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tienda/producto")
public class ProductoControlador {


    private final ProductoServicio servicio;

    public ProductoControlador(ProductoServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProductoUsuarioDTO>> mostrarProductos() {
        List<ProductoUsuarioDTO> productos = servicio.mostrarProductosUsuario();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/administrador/listar")
    public ResponseEntity<List<ProductoAdministradorDTO>> mostrarProductosAdministrador() {
        List<ProductoAdministradorDTO> productos = servicio.mostrarProductosAdmin();
        return ResponseEntity.ok(productos);
    }

    @PostMapping("/crear")
    public CrearProductoDTO crearProducto(@RequestBody CrearProductoDTO productoDTO) {
        return servicio.crearProductoAdmin(productoDTO);
    }

    @PutMapping("/administrador/actualizar/{serial}")
    public ActualizarProductoDTO actualizarProducto(@RequestBody ActualizarProductoDTO productoDTO, @PathVariable String serial) {
        return servicio.actualizarProducto(serial, productoDTO);
    }
}

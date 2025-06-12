package com.itsqmet.controller;

import com.itsqmet.entity.Producto;
import com.itsqmet.entity.Proveedor;
import com.itsqmet.service.ProductoService;
import com.itsqmet.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/producto")
public class ProductoController {
@Autowired
private ProductoService productoService;
//traer proveedores
    @Autowired
    private ProveedorService proveedorService;


    //listar todos los productos de la bd
    @GetMapping("/lista")
    public String mostrarProductos(Model model){
        List<Producto> productos=productoService.mostrarProductos();
        model.addAttribute("productos", productos);
        return "producto/lista";
    }
    //Insertar un nuevo producto
    //1.amuestro mi form y el nuevo producto que ingrese lo guardo en la variable producto
    @GetMapping("/formulario")
    public String mostrarFormularioProducto(Model model){
        List<Proveedor> proveedores= proveedorService.mostrarProveedores();
        model.addAttribute("proveedores",proveedores);
        model.addAttribute("producto",new Producto());
        return "producto/registro";
    }
    //2.guardo el producto que ingreso
    @PostMapping("/guardar")
    public String guardarProducto(Producto producto){
        productoService.GuardarProducto(producto);
        return "redirect:/producto/lista";
    }
    //Actualizar el producto
    @GetMapping("/actualizar/{id}")
    public String actualizarProducto(@PathVariable Long id, Model model){
        Optional<Producto> producto=productoService.buscarProductoId(id);
        model.addAttribute("proveedores", proveedorService.mostrarProveedores());
        model.addAttribute("producto", producto);
        return "producto/registro";
    }
    //Eliminar un producto
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return "redirect:/producto/lista";
    }
}

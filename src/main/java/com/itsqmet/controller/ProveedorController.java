package com.itsqmet.controller;

import com.itsqmet.entity.Proveedor;
import com.itsqmet.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;
    //listar todos los proveedores de la bd
    @GetMapping("/lista")
    public String mostrarProveedores(Model model){
        List<Proveedor> proveedores=proveedorService.mostrarProveedores();
        return "proveedor/lista";
    }
    //Insertar un nuevo proveedor
        //1.amuestro mi form y el nuevo proveedor que ingrese lo guardo en la variable proveedor
    @GetMapping("/formulario")
    public String mostrarFormularioProveedor(Model model){
        model.addAttribute("proveedor",new Proveedor());
        return "proveedor/registro";
    }
        //2.guardo el proveedor que ingreso
    @PostMapping("/guardar")
    public String guardarProveedor(Proveedor proveedor){
        proveedorService.GuardarProveedor(proveedor);
        return "redirect:/lista";
    }
    //Actualizar el proveedor

}

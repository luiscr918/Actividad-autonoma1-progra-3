package com.itsqmet.controller;

import com.itsqmet.entity.Factura;
import com.itsqmet.entity.Factura;
import com.itsqmet.service.FacturaService;
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
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    //listar todos las facturas de la bd
    @GetMapping("/lista")
    public String mostrarFacturas(Model model){
        List<Factura> facturas=facturaService.mostrarFacturas();
        return "factura/lista";
    }
    //Insertar una nueva factura
    //1.amuestro mi form y la nueva factura que ingrese la guardo en la variable factura
    @GetMapping("/formulario")
    public String mostrarFormularioFactura(Model model){
        model.addAttribute("factura",new Factura());
        return "factura/registro";
    }
    //2.guardo el factura que ingreso
    @PostMapping("/guardar")
    public String guardarFactura(Factura factura){
        facturaService.GuardarFactura(factura);
        return "redirect:/factura/lista";
    }
    //Actualizar el factura
    @GetMapping("/actualizar/{id}")
    public String actualizarFactura(@PathVariable Long id, Model model){
        Optional<Factura> factura=facturaService.buscarFacturaId(id);
        model.addAttribute("factura", factura);
        return "factura/registro";
    }
    //Eliminar un factura
    @GetMapping("/eliminar/{id}")
    public String eliminarFactura(@PathVariable Long id){
        facturaService.eliminarFactura(id);
        return "redirect:/factura/lista";
    }
}

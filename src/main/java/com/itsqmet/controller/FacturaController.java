package com.itsqmet.controller;

import com.itsqmet.entity.Cliente;
import com.itsqmet.entity.Factura;
import com.itsqmet.entity.Factura;
import com.itsqmet.entity.Producto;
import com.itsqmet.service.ClienteService;
import com.itsqmet.service.FacturaService;
import com.itsqmet.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProductoService productoService;

    //listar todos las facturas de la bd
    @GetMapping("/lista")
    public String mostrarFacturas(Model model){
        List<Factura> facturas=facturaService.mostrarFacturas();
        model.addAttribute("facturas",facturas);
        return "factura/lista";
    }
    //Insertar una nueva factura
    //1.amuestro mi form y la nueva factura que ingrese la guardo en la variable factura
    @GetMapping("/formulario")
    public String mostrarFormularioFactura(@RequestParam String cedula,
                                           @RequestParam Long id,
                                           Model model){
        // Aquí cargo los objetos de cliente y producto según los IDs
       Optional<Cliente>  cliente = clienteService.buscarClienteCedula(cedula);
        Optional<Producto> producto = productoService.buscarProductoId(id);

        Factura factura = new Factura();
        factura.setCliente(cliente.get());
        factura.setProducto(producto.get());
        model.addAttribute("factura", factura);
        return "factura/registro"; // Tu formulario
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

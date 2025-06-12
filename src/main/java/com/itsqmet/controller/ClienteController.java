package com.itsqmet.controller;

import com.itsqmet.entity.Cliente;
import com.itsqmet.entity.Cliente;
import com.itsqmet.entity.Producto;
import com.itsqmet.service.ClienteService;
import com.itsqmet.service.ProductoService;
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
@RequestMapping("/cliente")
public class ClienteController {
@Autowired
private ClienteService clienteService;
//llamar a la lista de produtos
    @Autowired
    private ProductoService productoService;


    //listar todos los clientes de la bd
    @GetMapping("/lista")
    public String mostrarClientes(Model model){
        List<Cliente> clientes=clienteService.mostrarClientes();
        List<Producto> productos= productoService.mostrarProductos();
        model.addAttribute("clientes",clientes);
        model.addAttribute("productos",productos);
        return "cliente/lista";
    }
    //Insertar un nuevo cliente
    //1.amuestro mi form y el nuevo cliente que ingrese lo guardo en la variable cliente
    @GetMapping("/formulario")
    public String mostrarFormularioCliente(Model model){
        model.addAttribute("cliente",new Cliente());
        return "cliente/registro";
    }
    //2.guardo el cliente que ingreso
    @PostMapping("/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.GuardarCliente(cliente);
        return "redirect:/cliente/lista";
    }
    //Actualizar el cliente
    @GetMapping("/actualizar/{cedula}")
    public String actualizarCliente(@PathVariable String cedula, Model model){
        Optional<Cliente> cliente=clienteService.buscarClienteCedula(cedula);
        model.addAttribute("cliente", cliente);
        return "cliente/registro";
    }
    //Eliminar un cliente
    @GetMapping("/eliminar/{cedula}")
    public String eliminarCliente(@PathVariable String cedula){
        clienteService.eliminarCliente(cedula);
        return "redirect:/cliente/lista";
    }
}

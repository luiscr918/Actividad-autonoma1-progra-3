package com.itsqmet.controller;

import com.itsqmet.entity.Producto;
import com.itsqmet.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ProductoService productoService;
    @GetMapping ("/")
    public String mostrarIndex(Model model){
        List<Producto> productos=productoService.mostrarProductos();
        model.addAttribute("productos",productos);
        return "index";
    }

}

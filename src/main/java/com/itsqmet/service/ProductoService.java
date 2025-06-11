package com.itsqmet.service;

import com.itsqmet.entity.Producto;
import com.itsqmet.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
@Autowired
private ProductoRepository productoRepository;
    //Mostrar los productos
    public List<Producto> mostrarProductos(){
        return productoRepository.findAll();
    }

    //Buscar producto por id
    public Optional<Producto> buscarProductoId(Long id){
        return  productoRepository.findById(id);

    }
    //Guardar producto
    public  Producto GuardarProducto(Producto producto){
        return productoRepository.save(producto);
    }
    //Eliminar el producto
    public void eliminarProducto(Long id){
        productoRepository.deleteById(id);
    }
}

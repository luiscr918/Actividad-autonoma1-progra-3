package com.itsqmet.service;

import com.itsqmet.entity.Cliente;
import com.itsqmet.entity.Proveedor;
import com.itsqmet.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {
@Autowired
private ProveedorRepository proveedorRepository;
    //Mostrar los proveedores
    public List<Proveedor> mostrarProveedores(){
        return proveedorRepository.findAll();
    }

    //Buscar proveedor por id
    public Optional<Proveedor> buscarProveedorId(Long id){
        return  proveedorRepository.findById(id);

    }
    //Guardar proveedor
    public  Proveedor GuardarProveedor(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }
    //Eliminar el proveedor
    public void eliminarProveedor(Long id){
        proveedorRepository.deleteById(id);
    }
}

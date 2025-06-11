package com.itsqmet.service;

import com.itsqmet.entity.Factura;
import com.itsqmet.entity.Proveedor;
import com.itsqmet.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {
@Autowired
private FacturaRepository facturaRepository;

    //Mostrar las facturas
    public List<Factura> mostrarFacturas(){
        return facturaRepository.findAll();
    }

    //Buscar factura por id
    public Optional<Factura> buscarFacturaId(Long id){
        return  facturaRepository.findById(id);

    }
    //Guardar factura
    public  Factura GuardarFactura(Factura factura){
        return facturaRepository.save(factura);
    }
    //Eliminar factura
    public void eliminarFactura(Long id){
        facturaRepository.deleteById(id);
    }
}

package com.itsqmet.service;

import com.itsqmet.entity.Cliente;
import com.itsqmet.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
@Autowired
    private ClienteRepository clienteRepository;

    //Mostrar los cliente
    public List<Cliente> mostrarClientes(){
        return clienteRepository.findAll();
    }

    //Buscar cliente por cedula
    public Optional<Cliente> buscarClienteCedula(String cedula){
        return  clienteRepository.findById(cedula);

    }
    //Guardar cliente
    public  Cliente GuardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    //Eliminar el cliente
    public void eliminarCliente(String cedula){
        clienteRepository.deleteById(cedula);
    }
}

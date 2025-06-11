package com.itsqmet.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cliente {
    @Id
    private String cedula;
    //relacion de cliente con factura
    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;

    private  String nombre;

    private String apellido;

    private String direccion;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fechaNacimiento;
}

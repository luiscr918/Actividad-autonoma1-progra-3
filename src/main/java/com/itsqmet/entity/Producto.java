package com.itsqmet.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Relacion con proveedor
    @ManyToOne
    @JoinColumn(name = "codigo_proveedor")
    private Proveedor proveedor;
    //Relacion de producto con factura
    @OneToMany(mappedBy = "producto",fetch = FetchType.LAZY)
    private List<Factura> facturas;


    private String nombre;

    private Double precioUnitario;

}

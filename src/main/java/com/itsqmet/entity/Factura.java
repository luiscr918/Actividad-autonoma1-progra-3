package com.itsqmet.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Relacion de factura con producto
    @ManyToOne
    @JoinColumn(name = "codigo_producto")
        private Producto producto;
    //Relacion de factura con cliente
    @ManyToOne
    @JoinColumn(name = "cedula_cliente")
    private Cliente cliente;


    private Integer cantidad;

    private Double subtotal;

    private Double total;
}

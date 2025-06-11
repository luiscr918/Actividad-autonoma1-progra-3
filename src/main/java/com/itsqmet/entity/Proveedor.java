package com.itsqmet.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Relacion con el producto
    @OneToMany(mappedBy = "proveedor",fetch = FetchType.LAZY)
    private List<Producto> productos;





    private  String nombre;

    private String direccion;
}

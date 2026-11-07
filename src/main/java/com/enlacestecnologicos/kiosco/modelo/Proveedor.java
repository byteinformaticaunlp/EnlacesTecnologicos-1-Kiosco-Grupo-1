package com.enlacestecnologicos.kiosco.modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="proveedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombre;
    private String direccion;
    private String telefono;

    @OneToMany
    @JoinColumn(name="producto_id")
    private List<Producto> productos;
}
package com.enlacestecnologicos.kiosco.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="detalles_venta")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int cantidad;

    @OneToMany
    @JoinColumn(name="producto_id")
    private List<Producto> producto;

    @ManyToOne
    @JoinColumn(name="venta_id")
    private Venta venta;

}

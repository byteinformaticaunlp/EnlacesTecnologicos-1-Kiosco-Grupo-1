package com.enlacestecnologicos.kiosco.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="detalles_venta")
@Setter
@Getter
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int cantidad;

    @OneToMany
    @JoinColumn(name="producto_id")
    private List<Producto> productos;

    @OneToOne
    @JoinColumn(name="venta_id")
    private Venta venta;

    public DetalleVenta(){
        this.productos = new LinkedList<Producto>();
    }

    public DetalleVenta(List<Producto> productos) {
        this.productos = new LinkedList<Producto>(productos);
        this.cantidad = this.productos.size();
    }

    public DetalleVenta(List<Producto> productos,Venta venta) {
        this.productos = new LinkedList<Producto>(productos);
        this.cantidad = this.productos.size();
        this.venta = venta;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        this.cantidad += 1;
    }

}

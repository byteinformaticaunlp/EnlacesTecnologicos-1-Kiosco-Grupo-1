package com.enlacestecnologicos.kiosco.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="productos")
@Getter
@Setter
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String codigoDeBarra;
    private String nombre;
    private double costo;
    private int stock;
    private int stockMinimo;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    public Producto(String codigoDeBarra, String nombre, double costo, int stock, int stockMinimo,String categoria,String marca) {
        this.codigoDeBarra = codigoDeBarra;
        this.nombre = nombre;
        this.costo = costo;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.categoria = new Categoria(categoria);
        this.marca = new Marca(marca);
    }

    public Producto(String codigoDeBarra, String nombre, double costo, int stock, int stockMinimo,double precio,String categoria,String marca) {
        this.codigoDeBarra = codigoDeBarra;
        this.nombre = nombre;
        this.costo = costo;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.categoria = new Categoria(categoria);
        this.marca = new Marca(marca);
        this.precio = precio;
    }
}
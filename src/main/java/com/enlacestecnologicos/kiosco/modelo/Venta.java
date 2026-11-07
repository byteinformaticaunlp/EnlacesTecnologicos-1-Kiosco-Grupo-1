package com.enlacestecnologicos.kiosco.modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ventas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clase_gen")
    private int id;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario; // Este lo haces para saber quien realizo la venta, podemos usar la caja
                             // directamente
    @DateTimeFormat
    private String fecha;

    private int caja; // con este calcular por turno cuanto va
    private double total;

    @ManyToOne
    @JoinColumn(name = "metodo_de_pago_id")
    private MetodoDePago metodo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="detalle_venta_id")
    private List<DetalleVenta> detalleVenta;
}

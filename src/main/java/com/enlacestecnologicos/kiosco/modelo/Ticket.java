package com.enlacestecnologicos.kiosco.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tickets")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @DateTimeFormat
    private String fecha;
    private double total;
    private String hora;

    @ManyToOne
    @JoinColumn(name="venta_id")
    private Venta venta;

    public Ticket(String fecha,double total,String hora,Venta venta) {
        this.fecha = fecha;
        this.total= total;
        this.hora = hora;
        this.venta = venta;
    }

}

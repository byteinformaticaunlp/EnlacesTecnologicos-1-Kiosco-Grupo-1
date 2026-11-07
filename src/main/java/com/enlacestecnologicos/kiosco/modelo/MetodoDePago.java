package com.enlacestecnologicos.kiosco.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="metodo_de_pago")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MetodoDePago {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String metodo;

}

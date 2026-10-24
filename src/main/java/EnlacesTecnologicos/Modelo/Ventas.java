package EnlacesTecnologicos.Modelo;

import java.util.LinkedList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clase_gen")
    private int id;
    private LinkedList<Producto> productos;
    private Usuario usuario; // Este lo haces para saber quien realizo la venta, podemos usar la caja
                             // directamente
    private String date;
    private int caja; // con este calcular por turno cuanto va
    private double total;
    private String metodoDePago;
}

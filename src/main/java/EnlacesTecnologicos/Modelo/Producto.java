package EnlacesTecnologicos.Modelo;

import jakarta.persistence.Entity;
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
public class Producto {
    @Id
    private int identificador;
    private String codigo_de_barras;
    private String nombre;
    private double costo;
    private int stock;
    private int stockMinimo;
    private double precio;
    private String Categoria;
    private String Marca;
    private Provedor provedor;

}
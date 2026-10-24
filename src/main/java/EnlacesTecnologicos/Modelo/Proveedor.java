package EnlacesTecnologicos.Modelo;

import java.util.LinkedList;

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
class Provedor {
    @Id
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private LinkedList<Producto> productos;
}
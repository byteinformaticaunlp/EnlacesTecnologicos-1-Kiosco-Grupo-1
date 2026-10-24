package EnlacesTecnologicos.Controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EnlacesTecnologicos.Modelo.Producto;

@RestController
@RequestMapping("/Productos") // endpoints productos
public class ProductosControladores {

    @GetMapping
    public String listarProductos() {
        return "lista de productos";
    }

    @GetMapping
    public double precioProducto(Producto producto) {
        return producto.getPrecio();
    }

    public void AgregarProducto(Producto producto) {
        // llamar a una funcionalidad de servicios
    }

    public void ModificarProducto(Producto producto) {
    }

    public void DesactivarProducto(Producto producto) {
    }

    public void CargaRapida(Producto producto) {
    }

    public void CargaNormal(Producto producto, int cantidad) {
    }
}

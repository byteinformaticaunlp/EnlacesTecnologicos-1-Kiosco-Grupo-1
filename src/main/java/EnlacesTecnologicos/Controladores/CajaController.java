package EnlacesTecnologicos.Controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Caja")
public class CajaController {
    public void AbrirCaja() {
    }

    public void CerrarCaja() {
    }

    public void Pagar() {

    }

    public void LimpiarProductos() {

    }

    public void AgregarProducto() {
    }

    public void EliminarProducto() {
    }

    public double precioProducto(Producto producto) {
        return producto.getPrecio();
    }

    private double SumaParcial() {
        return 0;
    }
}

package EnlacesTecnologicos.Controladores;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EnlacesTecnologicos.Modelo.Ventas;

@RestController
@RequestMapping("/Ventas")
public class VentasController {
    @GetMapping
    public String listarVentas() {
        return "lista de ventas";
    }

    public void ListarVentasPorFecha(String fechaBase, String fechaTope) {

    }

    public void RegistraVenta(Ventas venta) {
    }

    public void AnularVenta(Ventas venta) {
    }

}

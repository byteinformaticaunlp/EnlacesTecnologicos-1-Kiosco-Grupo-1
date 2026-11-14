package com.enlacestecnologicos.kiosco.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enlacestecnologicos.kiosco.modelo.Venta;

@RestController
@RequestMapping("/Ventas")
public class VentasController {
    @GetMapping
    public String listarVentas() {
        return "lista de ventas";
    }

    public void ListarVentasPorFecha(String fechaBase, String fechaTope) {

    }

    public void RegistraVenta(Venta venta) {
    }

    public void AnularVenta(Venta venta) {
    }

}

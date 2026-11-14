package com.enlacestecnologicos.kiosco.repositorios;

import com.enlacestecnologicos.kiosco.modelo.DetalleVenta;
import com.enlacestecnologicos.kiosco.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Long> {

    public List<DetalleVenta> findByCantidad(int cantidad);

    public List<DetalleVenta> findByCantidadGreaterThan(int cantidad);

    public List<DetalleVenta> findByCantidadLessThan(int cantidad);

    public List<DetalleVenta> findByVenta(Venta venta);
}

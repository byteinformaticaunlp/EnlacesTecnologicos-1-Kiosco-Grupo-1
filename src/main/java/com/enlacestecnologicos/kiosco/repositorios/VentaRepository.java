package com.enlacestecnologicos.kiosco.repositorios;

import com.enlacestecnologicos.kiosco.modelo.MetodoDePago;
import com.enlacestecnologicos.kiosco.modelo.Usuario;
import com.enlacestecnologicos.kiosco.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta,Long> {

    public List<Venta> findByFechaGreaterThan(String fecha);

    public List<Venta> findByFechaLessThan(String fecha);

    public List<Venta> findByUsuario(Usuario usuario);

    public List<Venta> findByCaja(int caja);

    public List<Venta> findByMetodoDePago(MetodoDePago metodo);


}

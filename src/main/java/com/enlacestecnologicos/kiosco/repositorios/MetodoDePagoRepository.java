package com.enlacestecnologicos.kiosco.repositorios;

import com.enlacestecnologicos.kiosco.modelo.MetodoDePago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MetodoDePagoRepository extends JpaRepository<MetodoDePago,Long> {

    public List<MetodoDePago> findByMetodo(String metodo);
}

package com.enlacestecnologicos.kiosco.repositorios;

import com.enlacestecnologicos.kiosco.modelo.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor,Long> {

    public List<Proveedor> findByNombre(String nombre);
}

package com.enlacestecnologicos.kiosco.repositorios;

import com.enlacestecnologicos.kiosco.modelo.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca,Long> {

    public List<Marca> findByNombre(String nombre);
}

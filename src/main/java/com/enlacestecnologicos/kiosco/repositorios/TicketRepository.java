package com.enlacestecnologicos.kiosco.repositorios;

import com.enlacestecnologicos.kiosco.modelo.Ticket;
import com.enlacestecnologicos.kiosco.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    public List<Ticket> findByFecha(String fecha);

    public List<Ticket> findByVenta(Venta venta);
}

package EnlacesTecnologicos.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EnlacesTecnologicos.Modelo.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}

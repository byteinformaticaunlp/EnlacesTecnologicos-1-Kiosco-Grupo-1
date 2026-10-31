package EnlacesTecnologicos.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EnlacesTecnologicos.Modelo.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
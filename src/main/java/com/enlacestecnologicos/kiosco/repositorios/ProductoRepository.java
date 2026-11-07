package com.enlacestecnologicos.kiosco.repositorios;

import com.enlacestecnologicos.kiosco.modelo.Categoria;
import com.enlacestecnologicos.kiosco.modelo.Marca;
import com.enlacestecnologicos.kiosco.modelo.Producto;
import com.enlacestecnologicos.kiosco.modelo.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

    public List<Producto> findByCodigoDeBarra(String codigoDeBarra);

    public List<Producto> findByNombre(String nombre);

    public List<Producto> findByCostoGreaterThan(double costo);

    public List<Producto> findByCostoLessThan(double costo);

    public List<Producto> findByStockGreaterThan(int stock);

    public List<Producto> findByStockLessThan(int stock);

    @Query("SELECT * FROM productos WHERE stock <= stock_minimo")
    public List<Producto> findByStockMinimo();

    public List<Producto> findByPrecionGreaterThan(double precio);

    public List<Producto> findByPrecioLessThan(double precio);

    public List<Producto> findByCategoria(Categoria categoria);

    public List<Producto> findByMarca(Marca marca);

    public List<Producto> findByProveedor(Proveedor proveedor);

}

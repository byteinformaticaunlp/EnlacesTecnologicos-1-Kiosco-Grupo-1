
package com.enlacestecnologicos.kiosco;

import com.enlacestecnologicos.kiosco.modelo.*;
import com.enlacestecnologicos.kiosco.repositorios.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class KioscoApplication {

	private static final Logger logger =
			LoggerFactory.getLogger(KioscoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KioscoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDb(
			CategoriaRepository categoriaRepository,
			MarcaRepository marcaRepository,
			ProveedorRepository proveedorRepository,
			ProductoRepository productoRepository,
			MetodoDePagoRepository metodoDePagoRepository,
			RolRepository rolRepository,
			UsuarioRepository usuarioRepository) {

		return args -> {

			// Evitar duplicar los datos al reiniciar la aplicación.
			if (categoriaRepository.count() > 0
					|| marcaRepository.count() > 0
					|| proveedorRepository.count() > 0
					|| productoRepository.count() > 0
					|| metodoDePagoRepository.count() > 0
					|| rolRepository.count() > 0
					|| usuarioRepository.count() > 0) {

				logger.info("La base de datos ya contiene registros. "
						+ "Se omite la carga de datos de ejemplo.");
				return;
			}

			// 1. CATEGORÍAS
			Categoria bebidas = categoriaRepository.save(
					new Categoria("Bebidas"));
			Categoria almacen = categoriaRepository.save(
					new Categoria("Almacén"));
			Categoria golosinas = categoriaRepository.save(
					new Categoria("Golosinas"));
			Categoria lacteos = categoriaRepository.save(
					new Categoria("Lácteos"));
			Categoria limpieza = categoriaRepository.save(
					new Categoria("Limpieza"));

			// 2. MARCAS
			Marca manaos = marcaRepository.save(new Marca("Manaos"));
			Marca villavicencio = marcaRepository.save(new Marca("Villavicencio"));
			Marca playadito = marcaRepository.save(new Marca("Playadito"));
			Marca marolio = marcaRepository.save(new Marca("Marolio"));
			Marca lucchetti = marcaRepository.save(new Marca("Lucchetti"));
			Marca guaymallen = marcaRepository.save(new Marca("Guaymallén"));
			Marca bagley = marcaRepository.save(new Marca("Bagley"));
			Marca laSerenisima = marcaRepository.save(new Marca("La Serenísima"));
			Marca ser = marcaRepository.save(new Marca("Ser"));
			Marca querubin = marcaRepository.save(new Marca("Querubín"));

			// 3. PROVEEDORES
			// Direcciones y teléfonos ficticios para pruebas.

			Proveedor distribuidoraSur = proveedorRepository.save(
					new Proveedor(
							"Distribuidora Sur S.R.L.",
							"Av. Hipólito Yrigoyen 12500, Burzaco, Buenos Aires",
							"11-4238-1001",
							new ArrayList<>()
					));

			Proveedor mayoristaLaPlata = proveedorRepository.save(
					new Proveedor(
							"Mayorista La Plata",
							"Calle 44 1234, La Plata, Buenos Aires",
							"221-456-7000",
							new ArrayList<>()
					));

			Proveedor distribuidoraOeste = proveedorRepository.save(
					new Proveedor(
							"Distribuidora del Oeste",
							"Av. Rivadavia 10500, CABA",
							"11-4632-8000",
							new ArrayList<>()
					));

			// 4. PRODUCTOS
			// Los códigos de barras y precios son ilustrativos.
			// Todos los precios están expresados en pesos argentinos.

			List<Producto> productosSur = productoRepository.saveAll(
					List.of(
							crearProducto("7790001000011",
									"Gaseosa Manaos Cola 2,25 L",
									1200, 30, 5, 1800,
									bebidas, manaos, distribuidoraSur),

							crearProducto("7790001000028",
									"Agua mineral Villavicencio 1,5 L",
									1000, 22, 5, 1500,
									bebidas, villavicencio, distribuidoraSur),

							crearProducto("7790001000035",
									"Yerba Playadito 1 kg",
									2800, 18, 4, 3900,
									almacen, playadito, distribuidoraSur)
					)
			);

			List<Producto> productosLaPlata = productoRepository.saveAll(
					List.of(
							crearProducto("7790001000042",
									"Arroz Marolio 1 kg",
									850, 20, 5, 1200,
									almacen, marolio, mayoristaLaPlata),

							crearProducto("7790001000059",
									"Fideos Lucchetti 500 g",
									750, 25, 6, 1100,
									almacen, lucchetti, mayoristaLaPlata),

							crearProducto("7790001000066",
									"Alfajor triple Guaymallén 70 g",
									380, 50, 12, 600,
									golosinas, guaymallen, mayoristaLaPlata),

							crearProducto("7790001000073",
									"Galletitas Chocolinas 170 g",
									900, 16, 4, 1300,
									golosinas, bagley, mayoristaLaPlata)
					)
			);

			List<Producto> productosOeste = productoRepository.saveAll(
					List.of(
							crearProducto("7790001000080",
									"Leche UAT entera La Serenísima 1 L",
									950, 24, 6, 1400,
									lacteos, laSerenisima, distribuidoraOeste),

							crearProducto("7790001000097",
									"Yogur bebible Ser frutilla 190 g",
									650, 15, 5, 950,
									lacteos, ser, distribuidoraOeste),

							crearProducto("7790001000103",
									"Lavandina Querubín 1 L",
									800, 14, 4, 1200,
									limpieza, querubin, distribuidoraOeste)
					)
			);

			// Vincular los productos con sus respectivos proveedores.
			distribuidoraSur.setProductos(productosSur);
			mayoristaLaPlata.setProductos(productosLaPlata);
			distribuidoraOeste.setProductos(productosOeste);

			proveedorRepository.saveAll(List.of(
					distribuidoraSur,
					mayoristaLaPlata,
					distribuidoraOeste
			));

			// 5. MÉTODOS DE PAGO
			metodoDePagoRepository.saveAll(List.of(
					new MetodoDePago("efectivo"),
					new MetodoDePago("tranferencia"),
					new MetodoDePago("qr"),
					new MetodoDePago("tarjeta")
			));

			// 6. ROLES
			Rol administrador = rolRepository.save(
					new Rol("administrador"));

			rolRepository.saveAll(List.of(
					new Rol("repositor"),
					new Rol("cajero")
			));

			// 7. USUARIO ADMINISTRADOR
			usuarioRepository.save(
					new Usuario("Alan", "1234", administrador)
			);

			// Resumen de la carga.
			logger.info("Datos de ejemplo cargados correctamente.");
			logger.info("Categorías: {}", categoriaRepository.count());
			logger.info("Marcas: {}", marcaRepository.count());
			logger.info("Proveedores: {}", proveedorRepository.count());
			logger.info("Productos: {}", productoRepository.count());
			logger.info("Métodos de pago: {}", metodoDePagoRepository.count());
			logger.info("Roles: {}", rolRepository.count());
			logger.info("Usuarios: {}", usuarioRepository.count());
		};
	}

	// Método auxiliar para construir productos.
	private static Producto crearProducto(
			String codigoDeBarra,
			String nombre,
			double costo,
			int stock,
			int stockMinimo,
			double precio,
			Categoria categoria,
			Marca marca,
			Proveedor proveedor) {

		Producto producto = new Producto();

		producto.setCodigoDeBarra(codigoDeBarra);
		producto.setNombre(nombre);
		producto.setCosto(costo);
		producto.setStock(stock);
		producto.setStockMinimo(stockMinimo);
		producto.setPrecio(precio);
		producto.setCategoria(categoria);
		producto.setMarca(marca);
		producto.setProveedor(proveedor);

		return producto;
	}
}

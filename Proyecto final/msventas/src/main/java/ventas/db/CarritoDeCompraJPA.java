package ventas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ventas.entities.CarritoDeCompra;

@RepositoryRestResource(path = "carritocompra")
public interface CarritoDeCompraJPA extends JpaRepository<CarritoDeCompra, Long> {
}

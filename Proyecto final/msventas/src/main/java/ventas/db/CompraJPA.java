package ventas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ventas.entities.Compra;

@RepositoryRestResource(path = "compra")
public interface CompraJPA extends JpaRepository<Compra, Long> {
}

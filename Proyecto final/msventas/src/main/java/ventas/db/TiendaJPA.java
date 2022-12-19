package ventas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ventas.entities.Tienda;

@RepositoryRestResource(path = "tienda")
public interface TiendaJPA extends JpaRepository<Tienda,Long> {
}

package ventas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ventas.entities.Comprador;

@RepositoryRestResource(path = "comprador")
public interface CompradorJPA extends JpaRepository<Comprador, Long>{
}

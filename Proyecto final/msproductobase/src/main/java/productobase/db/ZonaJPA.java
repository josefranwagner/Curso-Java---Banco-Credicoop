package productobase.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import productobase.entities.Zona;

@RepositoryRestResource(path = "zona")
public interface ZonaJPA extends JpaRepository<Zona, Long> {

}

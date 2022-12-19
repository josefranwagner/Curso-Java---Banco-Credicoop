package ventas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ventas.entities.Publicacion;

@RepositoryRestResource(path = "publicacion")
public interface PublicacionJPA extends JpaRepository<Publicacion,Long> {
}

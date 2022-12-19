package productobase.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import productobase.entities.PosiblePersonalizacion;

@RepositoryRestResource(path = "posiblepersonalizacion")
public interface PosiblePersonalizacionJPA extends JpaRepository<PosiblePersonalizacion, Long> {

}
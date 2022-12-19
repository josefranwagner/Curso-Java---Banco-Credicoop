package productobase.db;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import productobase.entities.ProductoBase;

@RepositoryRestResource(path = "productobase")
public interface ProductoBaseJPA extends JpaRepository<ProductoBase, Long> {

}
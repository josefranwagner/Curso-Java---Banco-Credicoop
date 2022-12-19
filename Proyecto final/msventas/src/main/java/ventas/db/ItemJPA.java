package ventas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ventas.entities.Item;

@RepositoryRestResource(path = "item")
public interface ItemJPA extends JpaRepository<Item, Long> {
}

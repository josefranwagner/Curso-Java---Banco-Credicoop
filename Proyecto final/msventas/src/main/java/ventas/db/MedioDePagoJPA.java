package ventas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ventas.entities.MedioDePago;

@RepositoryRestResource(path = "mediodepago")
public interface MedioDePagoJPA extends JpaRepository<MedioDePago,Long> {
}
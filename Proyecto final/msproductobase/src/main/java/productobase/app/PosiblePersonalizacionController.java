package productobase.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import productobase.db.PosiblePersonalizacionJPA;


@RestController
public class PosiblePersonalizacionController {

    @Autowired
    PosiblePersonalizacionJPA posiblePersonalizacionJPA;

    @GetMapping("/posiblepersonalizacion/{idPosiblePersonalizacion}")
    public boolean existePosiblePersonalizacion(@PathVariable("idPosiblePersonalizacion") Long id){
        return posiblePersonalizacionJPA.existsById(id);
    }
}

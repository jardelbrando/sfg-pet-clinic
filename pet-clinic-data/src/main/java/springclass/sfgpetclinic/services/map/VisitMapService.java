package springclass.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import springclass.sfgpetclinic.model.Visit;
import springclass.sfgpetclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Jardel Brandão
 * @created : 19/03/2025
 **/
@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getId() == null
        || object.getPet().getOwner().getId() == null) {
            throw  new RuntimeException("Invalid visit");
        }
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }
}

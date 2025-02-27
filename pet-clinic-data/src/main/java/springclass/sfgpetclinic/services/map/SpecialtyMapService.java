package springclass.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import springclass.sfgpetclinic.model.Specialty;
import springclass.sfgpetclinic.services.SpecialtyService;

import java.util.Set;

/**
 * @author Jardel Brandao
 * @date 27/02/2025
 */
@Service
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

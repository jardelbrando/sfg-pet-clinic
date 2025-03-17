package springclass.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springclass.sfgpetclinic.model.Specialty;

/**
 * @author : Jardel Brandão
 * @created : 17/03/2025
 **/
public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}

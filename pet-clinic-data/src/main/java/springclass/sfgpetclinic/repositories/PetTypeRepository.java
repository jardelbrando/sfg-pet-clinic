package springclass.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springclass.sfgpetclinic.model.PetType;

/**
 * @author : Jardel Brandão
 * @created : 17/03/2025
 **/
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

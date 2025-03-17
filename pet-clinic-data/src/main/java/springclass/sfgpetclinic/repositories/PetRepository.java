package springclass.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springclass.sfgpetclinic.model.Pet;

/**
 * @author : Jardel Brandão
 * @created : 17/03/2025
 **/
public interface PetRepository extends CrudRepository<Pet, Long> {
}

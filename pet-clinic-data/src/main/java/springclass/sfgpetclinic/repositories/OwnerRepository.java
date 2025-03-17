package springclass.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springclass.sfgpetclinic.model.Owner;

/**
 * @author : Jardel Brandão
 * @created : 17/03/2025
 **/
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}

package springclass.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springclass.sfgpetclinic.model.Vet;

/**
 * @author : Jardel Brandão
 * @created : 17/03/2025
 **/
public interface VetRepository extends CrudRepository<Vet, Long> {
}

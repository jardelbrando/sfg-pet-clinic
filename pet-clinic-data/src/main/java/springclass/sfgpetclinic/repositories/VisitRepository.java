package springclass.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springclass.sfgpetclinic.model.Visit;

/**
 * @author : Jardel Brandão
 * @created : 17/03/2025
 **/
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
